package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferRepository;
import com.soat.anti_gaspi.infrastructure.mappers.OfferMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
@AllArgsConstructor
public class OffersAdapter implements OfferRepository {

    private final OfferJpaRepository offerRepository;
    private final OfferMapper offerMapper;

    @Override
    public OfferId save(Offer offer) {
        var offerEntity = offerMapper.toEntity(offer);
        return offerMapper.toOffer(offerRepository.save(offerEntity)).getOfferId();
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
