package com.soat.anti_gaspi.application.exceptions;


// TODO Add exception + use non breaking exception + super message ?
public class InvalidDateFormat extends RuntimeException {

    private final String message;

    public InvalidDateFormat(String wrongParsedDate, String dateType) {
        this.message = String.format("%s is not a valid %s", wrongParsedDate, dateType);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
