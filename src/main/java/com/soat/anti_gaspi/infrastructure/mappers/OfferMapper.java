package com.soat.anti_gaspi.infrastructure.mappers;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.model.OfferEntity;
import com.soat.anti_gaspi.model.Status;

public class OfferMapper extends Mapper<Offer, OfferEntity> {

        @Override
        protected OfferEntity to(Offer offer) {
            return OfferEntity.OfferEntityBuilder.builder()
                    .naturalId(offer.getOfferId().naturalId())
                    .title(offer.getTitle())
                    .description(offer.getDescription())
                    .email(offer.getUser().getEmail().getValue())
                    .numberAddress(String.valueOf(offer.getAddress().getNumber()))
                    .streetAddress(offer.getAddress().getStreet())
                    .cityAddress(offer.getAddress().getCity())
                    .zipCodeAddress(offer.getAddress().getZipCode())
                    .country(offer.getAddress().getCountry())
                    .availabilityDate(offer.getAvailabilityDate().toLocalDateTime())
                    .expirationDate(offer.getExpirationDate().toLocalDateTime())
                    .status(Status.from(offer.getStatus().name()))
                    .build();
        }
}
