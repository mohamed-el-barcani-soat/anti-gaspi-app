package com.soat.anti_gaspi.controller;

import com.soat.anti_gaspi.application.OfferMapper;
import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.usecases.CreateOfferUseCase;
import com.soat.anti_gaspi.domain.usecases.GetOfferUseCase;
import com.soat.anti_gaspi.domain.usecases.GetPublishedOffersUseCase;
import com.soat.anti_gaspi.infrastructure.repositories.OfferJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Add validator ?
@Slf4j
@RestController
@RequestMapping(OfferController.PATH)
@AllArgsConstructor
public class OfferController {
    public static final String PATH = "/offers";
    private final CreateOfferUseCase createOffer;
    private final GetOfferUseCase getOffer;
    private final GetPublishedOffersUseCase getPublishedOffers;

    private final OfferMapper offerMapper = new OfferMapper();

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Validated OfferDto offerDto) {
        var offer = offerMapper.map(offerDto);

        var offerId = createOffer.create(offer);

        return new ResponseEntity<>(offerId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<OfferPage> getPaginatedPublishedOffers(@RequestParam int pageNumber,
                                                                 @RequestParam int pageSize,
                                                                 @RequestParam String sortBy,
                                                                 @RequestParam(defaultValue = "asc") String sortOrder) {

        List<Offer> allOffers = getPublishedOffers.get();
        var result = PaginatedOffersMapper.map(allOffers, pageNumber, pageSize, sortBy, sortOrder);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavedOfferDto> findById(@PathVariable("id") String id) {

        var offerId = new OfferId(id);
        // TODO use ooptional on offerId to extend notation
        return getOffer.get(offerId).map(OfferDtoMapper::map)
                .map(offer -> new ResponseEntity<>(offer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/validate")
    public ResponseEntity<Void> validateOffer(@PathVariable("id") String id) {
        // TODO implement confirmation
        return null;
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<Void> deleteOffer(@PathVariable("id") String id) {
        // TODO implement deletion
        return null;
    }
}
