package com.soat.anti_gaspi.domain;

import java.util.Optional;

public interface FindOfferRepository {
    Optional<Offer> find(OfferId offerId);
}
