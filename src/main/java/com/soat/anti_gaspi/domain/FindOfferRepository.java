package com.soat.anti_gaspi.domain;

import java.util.List;
import java.util.Optional;

public interface FindOfferRepository {
    Optional<Offer> find(OfferId offerId);
    Optional<Offer> findOfferByHash(String hash);
}
