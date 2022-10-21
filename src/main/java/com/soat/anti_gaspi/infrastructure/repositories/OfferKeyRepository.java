package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferKey;
import com.soat.anti_gaspi.domain.OfferKeyFinder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@AllArgsConstructor
public class OfferKeyRepository implements OfferKeyFinder {

    private final ConfirmationKeyOfferJpaRepository repository;

    @Override
    public Optional<OfferKey> findByOfferId(OfferId id) {
        return repository.findByOfferId(id.value())
                .map((entity) -> new OfferKey(entity.getHash(), entity.getCreationDate()));
    }
}
