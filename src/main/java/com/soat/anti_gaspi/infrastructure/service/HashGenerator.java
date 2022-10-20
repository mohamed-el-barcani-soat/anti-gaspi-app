package com.soat.anti_gaspi.infrastructure.service;

import com.soat.anti_gaspi.domain.Offer;

import java.security.NoSuchAlgorithmException;

public interface HashGenerator {
    String generate(Offer offer) throws NoSuchAlgorithmException;
}
