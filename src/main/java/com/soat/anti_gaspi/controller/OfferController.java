package com.soat.anti_gaspi.controller;

import com.soat.anti_gaspi.application.OfferMapper;
import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.usecases.CreateOfferUseCase;
import com.soat.anti_gaspi.domain.usecases.GetOfferUseCase;
import com.soat.anti_gaspi.domain.usecases.GetPublishedOffersUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(OfferController.PATH)
@AllArgsConstructor
public class OfferController {
    public static final String PATH = "/api/offers";
    private final CreateOfferUseCase createOffer;
    private final GetOfferUseCase getOffer;
    private final GetPublishedOffersUseCase getPublishedOffers;

    private final OfferMapper offerMapper = new OfferMapper();

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Validated OfferDto offerDto) {
        var offer = offerMapper.map(offerDto);

        var offerId = createOffer.create(offer);

        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(offerId)
                        .toUri()
        ).build();
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
