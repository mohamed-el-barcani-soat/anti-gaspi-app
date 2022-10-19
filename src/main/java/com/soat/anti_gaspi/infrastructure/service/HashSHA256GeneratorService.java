package com.soat.anti_gaspi.infrastructure.service;

import com.soat.anti_gaspi.domain.Offer;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Component
public class HashSHA256GeneratorService implements HashGenerator {
    public static volatile MessageDigest messageDigestSingleton;
    private static final Object syncObject = new Object();

    static public MessageDigest getInstance() {

        if (messageDigestSingleton == null) {
            synchronized(syncObject) {
                if (messageDigestSingleton == null) {
                    try {
                        messageDigestSingleton = MessageDigest.getInstance("SHA-512");
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return messageDigestSingleton;
    }

    public String generate (Offer offer){
        MessageDigest digest = getInstance();

        digest.update(offer.getOfferId().value()
                .getBytes());

        byte[] encodedHash = digest.digest();
        StringBuilder hexData = new StringBuilder();
        for (byte hash : encodedHash) {
            hexData.append(Integer.toHexString(0xFF & hash));
        }
        return hexData.toString();
    }
}
