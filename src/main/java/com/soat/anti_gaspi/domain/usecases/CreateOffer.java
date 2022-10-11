package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;

import java.util.UUID;


public class CreateOffer implements Usecase<Offer, UUID> {

    @Override
    public UUID handle(final Offer entity) {
        System.out.println(entity);
        return null;
    }
}
