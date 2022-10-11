package com.soat.anti_gaspi.infrastructure.email;

import com.soat.anti_gaspi.infrastructure.email.exception.NullOfferConfirmationException;
import javassist.NotFoundException;

public interface EmailGenerator {
    String generateEmailFromTemplate(OfferConfirmationParameters offerConfirmationParameters) throws NotFoundException, NullOfferConfirmationException;
}
