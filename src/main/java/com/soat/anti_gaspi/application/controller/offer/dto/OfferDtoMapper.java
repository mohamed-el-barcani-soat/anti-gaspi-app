package com.soat.anti_gaspi.application.controller.offer.dto;

import com.soat.anti_gaspi.domain.Address;
import com.soat.anti_gaspi.domain.Offer;

public class OfferDtoMapper {

    public static SavedOfferDto map(Offer offer) {
        return SavedOfferDto
                .builder()
                .offerId(offer.getOfferId().value())
                .username(offer.getUser().getUsername())
                .email(offer.getUser().getEmail().getValue())
                .title(offer.getTitle())
                .description(offer.getDescription())
                .expirationDate(offer.getExpirationDate().toLocalDateTime())
                .address(concatenateAddress(offer.getAddress()))

                .build();
    }

    private static String concatenateAddress(Address address) {
        return address.getStreet() + ", " + address.getCity() + " " + address.getCountry();
    }
}
