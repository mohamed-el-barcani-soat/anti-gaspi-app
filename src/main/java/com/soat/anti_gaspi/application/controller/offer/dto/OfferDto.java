package com.soat.anti_gaspi.application.controller.offer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Getter
public class OfferDto {

    @NotNull
    private UserDto user;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotNull
    private AddressDto address;

    @NotEmpty
    private String availabilityDate;

    @NotEmpty
    private String expirationDate;
}
