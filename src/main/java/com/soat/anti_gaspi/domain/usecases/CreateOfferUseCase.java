package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferRepository;

public class CreateOfferUseCase {
    private final OfferRepository offers;

    public CreateOfferUseCase(OfferRepository offers) {
        this.offers = offers;
    }

    public String create(final Offer offer) {
        offer.validate();
        var offerId = offers.save(offer);
        return offerId.value();
    }
}
