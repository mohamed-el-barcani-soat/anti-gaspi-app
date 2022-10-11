package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.infrastructure.repositories.OffersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@AllArgsConstructor
public class CreateOffer implements Usecase<Offer, UUID> {

    private final OffersRepository offers;
    @Override
    public UUID handle(final Offer entity) {
        System.out.println(entity);
        entity.create();
        offers.save(entity);
        return null;
    }
}
