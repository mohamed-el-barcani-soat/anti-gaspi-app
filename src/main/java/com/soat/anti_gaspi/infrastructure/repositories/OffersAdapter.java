package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.Offers;
import com.soat.anti_gaspi.infrastructure.mappers.OfferMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.Set;


@Component
@AllArgsConstructor
public class OffersAdapter implements Offers {

    private final OfferJpaRepository offerRepository;
    private final OfferMapper offerMapper;

    @Override
    public OfferId create(Offer offer) {
        var offerEntity = offerMapper.toEntity(offer);
        return offerMapper.toOffer(offerRepository.save(offerEntity)).getOfferId();
    }

    @Override
    public OfferId update(Offer entity) {
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
