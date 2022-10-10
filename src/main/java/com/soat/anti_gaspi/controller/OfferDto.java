package com.soat.anti_gaspi.controller;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class OfferDto {

    @NotEmpty
    private final String username;

    @NotEmpty
    private final String title;

    @NotEmpty
    private final String description;

    @NotEmpty
    @Email
    private final String email;

    @NotNull
    private final int streetNumber;

    private final String streetNumberIndicator;

    @NotEmpty
    private final String country;

    @NotEmpty
    private final String street;

    @NotEmpty
    private final String city;

    @NotEmpty
    private final String zipcode;

    @NotEmpty
    private final String availabilityDate;

    @NotEmpty
    private final String expirationDate;
}
