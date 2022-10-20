package com.soat.anti_gaspi.controller;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
//TODO rename moi ca
public class SavedOfferDto {
    String offerId;
    String title;
    String description;
    String username;
    String email;
    String address;
    LocalDateTime expirationDate;
}
