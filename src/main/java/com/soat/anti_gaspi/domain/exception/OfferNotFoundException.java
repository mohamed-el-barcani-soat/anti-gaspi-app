package com.soat.anti_gaspi.domain.exception;

// Change runtime exception to exception
public class OfferNotFoundException extends RuntimeException{
    public OfferNotFoundException(String message) {
        super(message);
    }
}
