package com.soat.anti_gaspi.domain.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soat.anti_gaspi.domain.EmailSender;
import com.soat.anti_gaspi.domain.OfferConfirmationRepository;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.exception.OfferNotFoundException;
import com.soat.anti_gaspi.domain.exception.UnableToSendEmailException;
import com.soat.anti_gaspi.infrastructure.email.EmailGenerator;

import java.text.MessageFormat;

public class SendConfirmationMailUseCase {
    private final OfferConfirmationRepository offerRepository;
    private final EmailGenerator emailGenerator;
    private final EmailSender emailSender;

    public SendConfirmationMailUseCase(OfferConfirmationRepository offerConfirmationRepository, EmailGenerator emailGenerator, EmailSender emailSender) {
        this.offerRepository = offerConfirmationRepository;
        this.emailGenerator = emailGenerator;
        this.emailSender = emailSender;
    }

    public void send(String offerIdStr) throws UnableToSendEmailException, JsonProcessingException {
        var offerId = new OfferId(offerIdStr);
        offerRepository.find(offerId).orElseThrow(() -> new OfferNotFoundException(MessageFormat.format("Offer with id {0} not found", offerId.value())));
    }
}
