package com.soat.anti_gaspi.controller;

import lombok.Data;

@Data
public class OfferDto {
    private final String companyName;
    private final String title;
    private final String description;
    private final String email;
    private final String address;
    private final String availabilityDate;
    private final String expirationDate;
}
