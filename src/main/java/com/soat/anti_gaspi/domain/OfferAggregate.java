package com.soat.anti_gaspi.domain;

import java.time.OffsetDateTime;

public class OfferAggregate {

    public static Offer create(
            String companyName, String title, String description,
            String email, String street, int streetNumber, String country, String zipcode, String city,
            OffsetDateTime availabilityDate, OffsetDateTime expirationDate) {


        /*var company = CompanyName.create().value(companyName).build();
        var user = User.create().email(email).build();
        var address = Address.create().city(city).number(streetNumber).street(street).zipcode(zipcode).country(country).build(); */

        var offerId = availabilityDate.toString().concat(email).concat(title);


        return Offer.builder()
                .build();

    }
}
