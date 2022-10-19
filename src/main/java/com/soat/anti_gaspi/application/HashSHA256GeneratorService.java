package com.soat.anti_gaspi.application;

import com.soat.anti_gaspi.domain.Offer;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
// TODO catch exception -> Singleton safe thread
public class HashSHA256GeneratorService implements HashGenerator{
    public String generate(Offer offer) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(offer.getOfferId().value()
                .getBytes(StandardCharsets.UTF_8));

        return new String(encodedHash, StandardCharsets.UTF_8);
    }
}
