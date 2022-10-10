package com.soat.anti_gaspi.application.offer.mappers;

import com.soat.anti_gaspi.controller.OfferDto;
import com.soat.anti_gaspi.domain.Offer;

public class OfferMapper {
    
    // Ajouter un vérificateur en propriété
    public static Offer to(OfferDto offerDto) {

        // Ici, passé par l'aggrégat pour travailler sur la donnée
        return Offer.builder()
        /*        .companyName(offerDto.companyName())
                .title(offerDto.title())
                .description(offerDto.description())
                .email(offerDto.email())
                .address(offerDto.address())
                .availabilityDate(offerDto.availabilityDate())
                .expirationDate(offerDto.expirationDate()) */



                .build();
    }
}
