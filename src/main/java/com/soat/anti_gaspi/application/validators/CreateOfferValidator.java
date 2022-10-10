package com.soat.anti_gaspi.application.validators;

import com.soat.anti_gaspi.application.exceptions.InvalidFormatException;
import com.soat.anti_gaspi.controller.OfferDto;
import com.soat.anti_gaspi.domain.Validator;

public class CreateOfferValidator implements Validator<OfferDto> {

    private static final String EMAIL_REGEX = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";

    @Override
    public void validate(OfferDto offerDto) {
        checkMail(offerDto.getEmail());
        checkPrecedenceDate(offerDto.getExpirationDate(), offerDto.getAvailabilityDate());
    }

    private void checkPrecedenceDate(String expirationDate, String availabilityDate) {

    }


    private void checkMail(String mail) {
        if (!mail.matches(EMAIL_REGEX)) throw new InvalidFormatException(mail, "mail");
    }
}
