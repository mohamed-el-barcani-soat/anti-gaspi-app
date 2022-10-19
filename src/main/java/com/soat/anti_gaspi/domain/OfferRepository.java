package com.soat.anti_gaspi.domain;


import java.util.Optional;

public interface OfferRepository  {
    OfferId create(Offer entity);
    Optional<Offer> update(Offer entity);
    void delete(Offer entity);
    Optional<Offer> find(OfferId offerId);
}
