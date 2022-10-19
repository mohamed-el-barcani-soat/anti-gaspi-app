package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferRepository;

import java.util.Optional;


public class GetOfferUseCase {

    // TODO use implementation
    private final OfferRepository offerRepository;

    public GetOfferUseCase(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Optional<Offer> get(final OfferId id) {
        return offerRepository.find(id);
    }

}
