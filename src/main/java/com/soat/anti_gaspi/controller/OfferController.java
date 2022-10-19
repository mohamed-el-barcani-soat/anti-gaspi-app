package com.soat.anti_gaspi.controller;

import com.soat.anti_gaspi.application.OfferMapper;
import com.soat.anti_gaspi.domain.Address;
import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.usecases.CreateOfferUseCase;
import com.soat.anti_gaspi.domain.usecases.GetOfferUseCase;
import com.soat.anti_gaspi.domain.usecases.GetPublishedOffersUseCase;
import com.soat.anti_gaspi.infrastructure.repositories.ContactJpaRepository;
import com.soat.anti_gaspi.infrastructure.repositories.OfferJpaRepository;
import com.soat.anti_gaspi.model.Contact;
import com.soat.anti_gaspi.model.OfferEntity;
import com.soat.anti_gaspi.model.Status;
import com.soat.anti_gaspi.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Add validator ?
@Slf4j
@RestController
@RequestMapping(OfferController.PATH)
public class OfferController {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final String PATH = "/api/offers";
    private final EmailService smailService;
    private final OfferJpaRepository offerRepository;
    private final ContactJpaRepository contactRepository;
    private final Clock clock;
    private final CreateOfferUseCase createOffer;
    private final GetOfferUseCase getOffer;
    private final GetPublishedOffersUseCase getPublishedOffers;

    private static final String FRENCH_PHONE_NUM_REGEX = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$";

    private final OfferMapper offerMapper = new OfferMapper();

    public OfferController(@Qualifier("emailService") EmailService smailService, OfferJpaRepository offerRepository, ContactJpaRepository contactRepository, Clock clock, CreateOfferUseCase createOffer, GetOfferUseCase getOffer, GetPublishedOffersUseCase getPublishedOffers) {
        this.smailService = smailService;
        this.offerRepository = offerRepository;
        this.contactRepository = contactRepository;
        this.clock = clock;

        this.createOffer = createOffer;
        this.getOffer = getOffer;
        this.getPublishedOffers = getPublishedOffers;
    }

    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody @Validated OfferDto offerDto) {
        // Use validator of spring instead of mapper one ?
        var of = offerMapper.map(offerDto);

        var offerId = createOffer.create(of);

        return new ResponseEntity<>(UUID.randomUUID(), HttpStatus.CREATED);
    }

    BiPredicate<String, String> fieldValidator = (fieldValue, fieldName) -> {
        boolean test = !fieldValue.isEmpty() && !fieldValue.isBlank();
        if (!test) {
            log.warn("{} not valid  :(", fieldName);
        }
        return test;
    };

    @PostMapping("/{id}/confirm")
    public ResponseEntity<Void> confirm(@PathVariable("id") UUID uuid) {
        Optional<OfferEntity> maybeOffer = offerRepository.findById(uuid.toString());
        AtomicReference<HttpStatus> status = new AtomicReference<>(HttpStatus.NOT_FOUND);
//        maybeOffer.ifPresent(offerEntity -> {
//            offerEntity.setStatus(Status.PUBLISHED);
//            offerRepository.save(offerEntity);
//            status.set(HttpStatus.ACCEPTED);
//        });
        return new ResponseEntity<>(status.get());
    }

    @GetMapping
    public ResponseEntity<OfferPage> getPublishedOffers(@RequestParam int pageNumber,
                                                        @RequestParam int pageSize,
                                                        @RequestParam String sortBy,
                                                        @RequestParam(defaultValue = "asc") String sortOrder) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, "desc".equals(sortOrder) ? Sort.by(sortBy).descending() : Sort.by(sortBy));

        Page<OfferEntity> allOffers = offerRepository.findAllByStatus(Status.PUBLISHED, pageable);

        List<SavedOffer> savedOffers = allOffers.stream()
                .map(this::toOfferDto)
                .toList();

        var result = new OfferPage(savedOffers, allOffers.getTotalElements());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private SavedOffer toOfferDto(Offer offer) {
        return SavedOffer
                .builder()
                .offerId(offer.getOfferId().value())
                .username(offer.getUser().getUsername())
                .email(offer.getUser().getEmail().getValue())
                .title(offer.getTitle())
                .description(offer.getDescription())
                .expirationDate(offer.getExpirationDate().toLocalDateTime())
                .address(addressConcatenator(offer.getAddress()))

                .build();
    }

    private String addressConcatenator(Address address) {
        return address.getStreet() + ", " + address.getCity() + " " + address.getCountry();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavedOffer> findById(@PathVariable("id") String id) {

        var offerId = new OfferId(id);
        // TODO use ooptional on offerId to extend notation
        return getOffer.get(offerId).map(this::toOfferDto)
                .map(offer -> new ResponseEntity<>(offer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        offerRepository.deleteById(id.toString());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/{id}/contact")
    public ResponseEntity<UUID> createContact(@PathVariable("id") UUID id, @RequestBody ContactToSave contactToSave) {
        Contact contact = new Contact(
                contactToSave.lastName(),
                contactToSave.firstName(),
                contactToSave.phoneNumber(),
                contactToSave.messageContent(),
                contactToSave.offerId()
        );

        contact.setId(UUID.randomUUID());
        if (!fieldValidator.test(contact.getFirstName(), "FirstName") ||
                !fieldValidator.test(contact.getLastName(), "LastName") ||
                !validMatch.test(contact.getPhoneNumber(), FRENCH_PHONE_NUM_REGEX)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        final Contact savedContact = contactRepository.save(contact);
        final OfferEntity offerEntity = offerRepository.findById(id.toString()).orElse(null);
        smailService.sendEmail(contactToSave.lastName() + "is interested to your offer", null, "toto");
        return new ResponseEntity<>(savedContact.getId(), HttpStatus.CREATED);
    }

    BiPredicate<String, String> validMatch = (value, regex) -> {
        final Pattern r = Pattern.compile(regex);
        final Matcher m = r.matcher(value);
        return m.matches();
    };


}
