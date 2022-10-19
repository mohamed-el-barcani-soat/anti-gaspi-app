package com.soat.anti_gaspi.application;

import com.soat.anti_gaspi.domain.Offer;

import java.security.NoSuchAlgorithmException;

public interface HashGenerator {
    public String generate(Offer offer) throws NoSuchAlgorithmException;
}
