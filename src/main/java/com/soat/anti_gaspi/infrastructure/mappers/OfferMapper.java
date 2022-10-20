package com.soat.anti_gaspi.infrastructure.mappers;

import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.infrastructure.model.OfferEntity;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class OfferMapper {

        public OfferEntity toEntity(Offer offer) {
            return OfferEntity.builder()
                    .naturalId(offer.getOfferId().value())
                    .title(offer.getTitle())
                    .description(offer.getDescription())
                    .email(offer.getUser().getEmail().getValue())
                    .street(offer.getAddress().getStreet())
                    .city(offer.getAddress().getCity())
                    .zipCode(offer.getAddress().getZipCode())
                    .country(offer.getAddress().getCountry())
                    .availabilityDate(offer.getAvailabilityDate().toLocalDateTime())
                    .expirationDate(offer.getExpirationDate().toLocalDateTime())
                    .status(offer.getStatus().getValue())
                    .build();
        }

    public Offer toOffer(OfferEntity offerEntity) {
        return Offer.builder()
                .offerId(new OfferId(offerEntity.getNaturalId()))
                .title(offerEntity.getTitle())
                .description(offerEntity.getDescription())
                .user(User.builder().email(Email.builder().value(offerEntity.getEmail()).build()).build())
                .address(
                        Address.builder()
                                .number(
                                        NumberIndicator.builder().number(offerEntity.getNumber()).build())
                                .street(offerEntity.getStreet())
                                .city(offerEntity.getCity())
                                .zipcode(offerEntity.getZipCode())
                                .country(offerEntity.getCountry())
                                .build())
                .availabilityDate(offerEntity.getAvailabilityDate().atOffset(OffsetDateTime.now().getOffset()))
                .expirationDate(offerEntity.getExpirationDate().atOffset(OffsetDateTime.now().getOffset()))
                .status(Status.from(offerEntity.getStatus()))
                .build();
    }
}
