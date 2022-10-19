package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferRepository;

public class CreateOfferUseCase {
    private final OfferRepository offerRepository;

    public CreateOfferUseCase(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public String create(final Offer offer) {
        offer.validateCreation();
        var offerId = offerRepository.create(offer);
        return offerId.value();
    }
}
