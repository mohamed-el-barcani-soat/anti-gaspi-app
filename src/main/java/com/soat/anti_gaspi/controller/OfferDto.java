package com.soat.anti_gaspi.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class OfferDto {

    @NotNull
    private final UserDto user;

    @NotEmpty
    private final String title;

    @NotEmpty
    private final String description;

    @NotNull
    private final AddressDto address;

    @NotEmpty
    private final String availabilityDate;

    @NotEmpty
    private final String expirationDate;
}
