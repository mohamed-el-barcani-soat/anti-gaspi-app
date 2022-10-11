package com.soat.anti_gaspi.domain;

import java.util.Set;

public interface OfferRepository extends DomainRepository<Offer, OfferId> {
    @Override
    OfferId save(Offer entity);

    @Override
    void delete(Offer entity);

    @Override
    Offer find(OfferId offerId);

    @Override
    Set<Offer> findAll();
}
