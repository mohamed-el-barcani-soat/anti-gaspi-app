package com.soat.anti_gaspi.application.controller.offer.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;


// Todo remove builder and data for no args and setter
@Data
public class AddressDto {

    @NotEmpty
    private final String country;

    @NotEmpty
    private final String street;

    @NotEmpty
    private final String city;

    private final String zipcode;
}
