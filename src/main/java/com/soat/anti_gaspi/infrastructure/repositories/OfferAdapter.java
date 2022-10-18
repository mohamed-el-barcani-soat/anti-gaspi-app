package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferRepository;
import com.soat.anti_gaspi.infrastructure.mappers.OfferMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class OfferAdapter implements OfferRepository {

    private final OfferJpaRepository offerRepository;
    private final OfferMapper offerMapper;

    @Override
    public OfferId create(Offer offer) {
        return this.save(offer).getOfferId();
    }

    @Override
    public Offer update(Offer offer) {
        return this.save(offer);
    }

    @Override
    public void delete(Offer offer) {

    }

    @Override
    public Offer find(OfferId offerId) {
        return null;
    }

    private Offer save(Offer offer) {
        var offerEntity = offerRepository.save(offerMapper.toEntity(offer));
        return offerMapper.toOffer(offerEntity);
    }
}
