package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.Offers;

public class CreateOfferUseCase {
    private final Offers offers;

    public CreateOfferUseCase(Offers offers) {
        this.offers = offers;
    }

    public String create(final Offer offer) {
        offer.validate();
        var offerId = offers.create(offer);
        return offerId.value();
    }
}
