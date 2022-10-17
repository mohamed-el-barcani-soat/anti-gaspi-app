package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferRepository;
import com.soat.anti_gaspi.infrastructure.mappers.OfferMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class OfferRepositoryAdapter implements OfferRepository {

    private final OfferJpaRepository offerRepository;
    private final OfferMapper offerMapper;

    @Override
    public OfferId create(Offer offer) {
        var offerEntity = offerMapper.toEntity(offer);
        return offerMapper.toOffer(offerRepository.save(offerEntity)).getOfferId();
    }

    @Override
    public Offer update(Offer entity) { //TODO RETURN OBJECT
        return null;
    }

    @Override
    public void delete(Offer entity) {

    }

    @Override
    public Offer find(OfferId offerId) {
        return null;
    }
}
