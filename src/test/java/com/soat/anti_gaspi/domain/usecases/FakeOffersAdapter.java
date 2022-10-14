package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.Offers;

import java.util.Set;

public class FakeOffersAdapter implements Offers {

    @Override
    public OfferId create(Offer entity) {
        var offerId = new OfferId("fakeId");
        return offerId;    }

    @Override
    public OfferId update(Offer entity) {
        return null;
    }

    @Override
    public void delete(Offer entity) {

    }

    @Override
    public Offer find(OfferId offerId) {
        return null;
    }

    @Override
    public Set<Offer> findAll() {
        return null;
    }
}
