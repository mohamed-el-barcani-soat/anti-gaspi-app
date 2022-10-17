package com.soat.anti_gaspi.domain;


public interface OfferRepository  {
    OfferId create(Offer entity);
    Offer update(Offer entity);
    void delete(Offer entity);
    Offer find(OfferId offerId);
}
