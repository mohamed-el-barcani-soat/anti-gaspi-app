package com.soat.anti_gaspi.application.exceptions;

public class InvalidFormatException extends RuntimeException {
    private final String message;

    public InvalidFormatException(String wrongValue, String formatType) {
        this.message = String.format("%s is not a valid %s", wrongValue, formatType);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
