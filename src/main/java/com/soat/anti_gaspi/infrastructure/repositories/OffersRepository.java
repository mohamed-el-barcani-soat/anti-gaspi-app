package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.DomainRepository;
import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
@AllArgsConstructor
public class OffersRepository implements DomainRepository<Offer, OfferId> {


    private final OfferJpaRepository offerRepository;

    @Override
    public OfferId save(Offer entity) {
        return null;
    }

    @Override
    public void delete(Offer entity) {

    }

    @Override
    public Offer find(OfferId offerId) {
        return null;
    }

    @Override
    public Set<Offer> findAll() {
        return null;
    }
}
