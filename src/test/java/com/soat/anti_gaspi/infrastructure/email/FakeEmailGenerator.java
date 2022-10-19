package com.soat.anti_gaspi.infrastructure.email;

import com.soat.anti_gaspi.infrastructure.email.exception.NullOfferConfirmationException;
import javassist.NotFoundException;

import java.text.MessageFormat;

public class FakeEmailGenerator implements EmailGenerator {
    @Override
    public String generateEmailFromTemplate(OfferConfirmationParameters offerConfirmationParameters) throws NotFoundException, NullOfferConfirmationException {
        return "<div>" +
                MessageFormat.format("title : {} -", offerConfirmationParameters.title()) +
                MessageFormat.format("description : {} -", offerConfirmationParameters.description()) +
                MessageFormat.format("username : {} -", offerConfirmationParameters.username()) +
                MessageFormat.format("address : {} -", offerConfirmationParameters.address()) +
                MessageFormat.format("availabilityDate : {} -", offerConfirmationParameters.availabilityDate()) +
                MessageFormat.format("expirationDate : {} -", offerConfirmationParameters.expirationDate()) +
                MessageFormat.format("validateLink : {} -", offerConfirmationParameters.validateLink()) +
                MessageFormat.format("rejectLink : {} -", offerConfirmationParameters.rejectLink()) +
                "/div>";
    }
}
