package com.soat.anti_gaspi.domain;

import java.util.Set;

public interface Offers extends DomainRepository<Offer, OfferId> {
    @Override
    OfferId create(Offer entity);

    @Override
    OfferId update(Offer entity);

    @Override
    void delete(Offer entity);

    @Override
    Offer find(OfferId offerId);

    @Override
    Set<Offer> findAll();
}
