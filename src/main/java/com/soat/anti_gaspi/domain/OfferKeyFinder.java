package com.soat.anti_gaspi.domain;

import java.util.Optional;

public interface OfferKeyFinder {
    Optional<OfferKey> findByOfferId(final OfferId id);
}
