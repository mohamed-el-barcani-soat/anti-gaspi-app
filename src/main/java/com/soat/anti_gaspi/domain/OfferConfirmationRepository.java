package com.soat.anti_gaspi.domain;

import java.util.Optional;

// TODO : change to FindOfferRepository
public interface OfferConfirmationRepository {
    Optional<Offer> find(OfferId offerId);
}
