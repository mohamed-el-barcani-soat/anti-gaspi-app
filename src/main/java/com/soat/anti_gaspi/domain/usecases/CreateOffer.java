package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.infrastructure.repositories.OffersRepository;

public class CreateOffer implements Usecase<Offer, String> {

    private final OffersRepository offers;

    public CreateOffer(OffersRepository offers) {
        this.offers = offers;
    }

    @Override
    public String handle(final Offer entity) {
        entity.create();
        offers.save(entity);
        return null;
    }
}
