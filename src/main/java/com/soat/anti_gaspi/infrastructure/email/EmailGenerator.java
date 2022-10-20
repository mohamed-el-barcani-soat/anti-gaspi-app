package com.soat.anti_gaspi.infrastructure.email;

import com.soat.anti_gaspi.infrastructure.email.exception.NullOfferConfirmationException;


public interface EmailGenerator {
    String generateEmailFromTemplate(OfferConfirmationParameters offerConfirmationParameters) throws NullOfferConfirmationException;
}
