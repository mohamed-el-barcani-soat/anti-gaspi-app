package com.soat.anti_gaspi.domain.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.domain.exception.OfferNotFoundException;
import com.soat.anti_gaspi.domain.exception.UnableToSendEmailException;
import com.soat.anti_gaspi.infrastructure.email.EmailGenerator;

import java.text.MessageFormat;

public class SendConfirmationMailUseCase {
    private final FindOfferRepository offerRepository;
    private final LinksService linksService;
    private final EmailGenerator emailGenerator;
    private final EmailSender emailSender;

    public SendConfirmationMailUseCase(FindOfferRepository findOfferRepository, LinksService linksService, EmailGenerator emailGenerator, EmailSender emailSender) {
        this.offerRepository = findOfferRepository;
        this.linksService = linksService;
        this.emailGenerator = emailGenerator;
        this.emailSender = emailSender;
    }

    public void send(String offerIdStr) throws UnableToSendEmailException, JsonProcessingException {
        var offerId = new OfferId(offerIdStr);
        Offer foundOffer = offerRepository.find(offerId).orElseThrow(() -> new OfferNotFoundException(MessageFormat.format("Offer with id {0} not found", offerId.value())));

        // TODO : create and call link service to get pair of link that generate token and links

        // TODO : with links and offer info generate email body
    }
}
