package com.soat.anti_gaspi.domain;

import java.time.OffsetDateTime;

public class OfferAggregate {

    public static Offer create(
            User user, String title, String description, Address address, OffsetDateTime availabilityDate, OffsetDateTime expirationDate
    ) {

        return Offer.builder()
                .id(createId(availabilityDate, user.getEmail(), title))
                .user(user)
                .title(title)
                .description(description)
                .address(address)
                .availabilityDate(availabilityDate)
                .expirationDate(expirationDate)
                .build();

    }

    private static OfferId createId(OffsetDateTime availabilityDate, Email email, String title) {
        var offerId = availabilityDate.toString().concat(email.getValue()).concat(title);

        return new OfferId(offerId);
    }
}
