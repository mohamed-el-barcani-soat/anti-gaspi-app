package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferRepository;

import java.util.Optional;

public class FakeOfferRepositoryAdapter implements OfferRepository {

    @Override
    public OfferId create(Offer entity) {
        var offerId = new OfferId("fakeId");
        return offerId;    }

    @Override
    public Optional<Offer> update(Offer entity) {
        return null;
    }

    @Override
    public void delete(Offer entity) {

    }

    @Override
    public Offer find(OfferId offerId) {
        return null;
    }
}
