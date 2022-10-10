package com.soat.anti_gaspi.application;

import com.soat.anti_gaspi.application.validators.CreateOfferValidator;
import com.soat.anti_gaspi.controller.OfferDto;
import com.soat.anti_gaspi.domain.*;

import java.time.OffsetDateTime;

public class OfferMapper extends Mapper<OfferDto, Offer, CreateOfferValidator> {

    public OfferMapper() {
        super(new CreateOfferValidator());
    }

    @Override
    Offer to(OfferDto source) {
        return OfferAggregate.builder()
                .user(User.builder()
                        .username(source.getUsername())
                        .email(Email.builder()
                                .value(source.getEmail())
                                .build())
                        .build())
                .status(Status.PENDING)
                .title(source.getTitle())
                .description(source.getDescription())
                .address(Address.builder()
                        .number(NumberIndicator.builder()
                                .number(source.getStreetNumber())
                                .indicator(source.getStreetNumberIndicator())
                                .build())
                        .city(source.getCity())
                        .country(source.getCountry())
                        .zipcode(source.getZipcode())
                        .street(source.getStreet())
                        .build())
                .availabilityDate(OffsetDateTime.parse(source.getAvailabilityDate()))
                .expirationDate(OffsetDateTime.parse(source.getExpirationDate()))
                .build();
    }

}
