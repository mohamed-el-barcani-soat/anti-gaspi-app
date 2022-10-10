package com.soat.anti_gaspi.application.validators;

import com.soat.anti_gaspi.application.exceptions.InvalidDateFormat;
import com.soat.anti_gaspi.application.exceptions.InvalidFormatException;
import com.soat.anti_gaspi.application.structures.mappers.Validator;
import com.soat.anti_gaspi.controller.OfferDto;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;

public class CreateOfferValidator implements Validator<OfferDto> {

    private static final String EMAIL_REGEX = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";

    @Override
    public void validate(OfferDto offerDto) {
        checkMail(offerDto.getUser().getEmail());
        checkDatesFormat(offerDto.getExpirationDate(), offerDto.getAvailabilityDate());
    }

    private void checkDatesFormat(String expirationDate, String availabilityDate) {
        try {
            OffsetDateTime.parse(expirationDate);
            OffsetDateTime.parse(availabilityDate);
        } catch (DateTimeParseException exception) {
            throw new InvalidDateFormat(exception.getParsedString(), OffsetDateTime.class.getTypeName());
        }
    }

    private void checkMail(String mail) {
        if (!mail.matches(EMAIL_REGEX)) throw new InvalidFormatException(mail, "mail");
    }
}
