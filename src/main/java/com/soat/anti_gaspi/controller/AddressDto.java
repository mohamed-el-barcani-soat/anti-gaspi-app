package com.soat.anti_gaspi.controller;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


// Todo remove builder and data for no args and setter
@Data
public class AddressDto {
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

}
