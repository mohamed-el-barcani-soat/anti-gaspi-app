package com.soat.anti_gaspi.infrastructure.repositories.email;

import com.soat.anti_gaspi.domain.Hash;
import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferIdHashRepository;

import java.util.Optional;

public class FakeOfferIdHashRepository implements OfferIdHashRepository {
    @Override
    public Hash updateWithHash(Offer offer){
        return new Hash("an hash");
    }

    @Override
    public Optional<OfferId> findOfferIdByHash(Hash hash) {
        return Optional.empty();
    }
}
