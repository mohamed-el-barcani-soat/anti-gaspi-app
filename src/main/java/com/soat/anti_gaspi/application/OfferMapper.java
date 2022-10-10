package com.soat.anti_gaspi.application;

import com.soat.anti_gaspi.application.structures.mappers.Mapper;
import com.soat.anti_gaspi.application.validators.CreateOfferValidator;
import com.soat.anti_gaspi.controller.OfferDto;
import com.soat.anti_gaspi.domain.*;

import java.time.OffsetDateTime;

public class OfferMapper extends Mapper<OfferDto, Offer, CreateOfferValidator> {

    public OfferMapper() {
        super(new CreateOfferValidator());
    }

    @Override
    protected Offer to(OfferDto source) {
        return OfferAggregate.builder()
                .user(User.builder()
                        .username(source.getUser().getUsername())
                        .email(Email.builder()
                                .value(source.getUser().getEmail())
                                .build())
                        .build())
                .status(Status.PENDING)
                .title(source.getTitle())
                .description(source.getDescription())
                .address(Address.builder()
                        .number(NumberIndicator.builder()
                                .number(source.getAddress().getStreetNumber())
                                .indicator(source.getAddress().getStreetNumberIndicator())
                                .build())
                        .city(source.getAddress().getCity())
                        .country(source.getAddress().getCountry())
                        .zipcode(source.getAddress().getZipcode())
                        .street(source.getAddress().getStreet())
                        .build())
                .availabilityDate(OffsetDateTime.parse(source.getAvailabilityDate()))
                .expirationDate(OffsetDateTime.parse(source.getExpirationDate()))
                .build();
    }

}
