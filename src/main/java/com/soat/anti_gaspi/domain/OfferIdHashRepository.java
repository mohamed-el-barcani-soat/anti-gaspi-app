package com.soat.anti_gaspi.domain;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public interface OfferIdHashRepository {
    Hash updateWithHash(Offer offer) throws NoSuchAlgorithmException;

    Optional<OfferId> findOfferIdByHash(Hash hash);
}
