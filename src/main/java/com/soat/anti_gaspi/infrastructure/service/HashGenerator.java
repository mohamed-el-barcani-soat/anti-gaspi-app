package com.soat.anti_gaspi.infrastructure.service;

import com.soat.anti_gaspi.domain.Offer;

import java.security.NoSuchAlgorithmException;

// TODO : move to infrastructure.service
public interface HashGenerator {
    public String generate(Offer offer) throws NoSuchAlgorithmException;
}
