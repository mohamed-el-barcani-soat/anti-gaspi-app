package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.infrastructure.service.HashGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@AllArgsConstructor
public class OfferIdHashAdapter implements OfferIdHashRepository {
    private final Map<Hash, OfferId> mapOfferIdToken = new HashMap<>();
    private final HashGenerator hashGenerator;

    @Override
    public Hash updateWithHash(Offer offer) throws NoSuchAlgorithmException {
        var token = hashGenerator.generate(offer);
        Hash hash = new Hash(token);
        mapOfferIdToken.put(hash, offer.getOfferId());

        return hash;
    }

    @Override
    public Optional<OfferId> findOfferIdByHash(Hash hash) {
        return Optional
                .ofNullable(mapOfferIdToken.get(hash));
    }
}
