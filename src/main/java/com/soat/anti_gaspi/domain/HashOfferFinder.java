package com.soat.anti_gaspi.domain;

import java.util.Optional;

public interface HashOfferFinder {
    Optional<Offer> findOfferByHash(String hash);
}
