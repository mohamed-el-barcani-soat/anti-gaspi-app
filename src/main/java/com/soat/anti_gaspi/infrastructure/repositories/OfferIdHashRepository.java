package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public interface OfferIdHashRepository {
    Hash updateWithHash(Offer offer) throws NoSuchAlgorithmException;

    Optional<OfferId> findOfferIdByHash(Hash hash);
}
