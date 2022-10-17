package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.*;

import java.time.OffsetDateTime;

public class OfferHelper {
    public static Offer getValidOffer(final String id, final String email, // RENAME LA FONCTION EN GETOFFFER
                                      final String number, final OffsetDateTime availabilityDate,
                                      final OffsetDateTime expirationDate, final Status status) {
        return Offer.builder().offerId(
                        new OfferId(id)).user(User.builder()
                        .email(Email.builder().value(email).build())
                        .build())
                .address(Address.builder().number(NumberIndicator.builder().number(number).build())
                        .build())
                .availabilityDate(availabilityDate)
                .expirationDate(expirationDate)
                .status(status)
                .build();
    }
}