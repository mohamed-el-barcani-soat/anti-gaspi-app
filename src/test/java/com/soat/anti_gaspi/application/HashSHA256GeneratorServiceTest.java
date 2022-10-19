package com.soat.anti_gaspi.application;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

class HashSHA256GeneratorServiceTest {

    @Test
    void generate() throws NoSuchAlgorithmException {
        HashSHA256GeneratorService hashSHA256GeneratorService = new HashSHA256GeneratorService();
        var hash = hashSHA256GeneratorService.generate(Offer.builder().offerId(new OfferId("ID")).build());
        System.out.println(hash);
    }
}