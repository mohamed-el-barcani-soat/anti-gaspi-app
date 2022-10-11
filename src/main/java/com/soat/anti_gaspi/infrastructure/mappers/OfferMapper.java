package com.soat.anti_gaspi.infrastructure.mappers;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.model.OfferEntity;

import java.util.UUID;

public class OfferMapper extends Mapper<Offer, OfferEntity> {

        @Override
        protected OfferEntity to(Offer offer) {
            return new OfferEntity(
                    UUID.fromString(offer.getOfferId().value()),
                    offer.getTitle(),
                    offer.getDescription(),
                    offer.getUser().getEmail().getValue(),
                    offer.getAddress(),
                    offer.getAvailabilityDate().toLocalDate(),
                    offer.getExpirationDate().toLocalDate(),
                    offer.getStatus().name()
            );
        }
}
