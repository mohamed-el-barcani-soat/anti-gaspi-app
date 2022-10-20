package com.soat.anti_gaspi.domain.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.domain.exception.OfferNotFoundException;
import com.soat.anti_gaspi.domain.exception.UnableToSendEmailException;
import com.soat.anti_gaspi.infrastructure.email.EmailGenerator;
import com.soat.anti_gaspi.infrastructure.email.OfferConfirmationParameters;
import com.soat.anti_gaspi.infrastructure.email.exception.NullOfferConfirmationException;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;

public class SendConfirmationMailUseCase {
    private static final String CONFIRMATION_EMAIL_SUBJECT = "Confirmation de votre offre";
    private static final String EMAIL_SENDER = "antigaspi.teamjava@gmail.com";
    private final FindOfferRepository offerRepository;
    private final LinksService linksService;
    private final EmailGenerator emailGenerator;
    private final EmailSender emailSender;

    public SendConfirmationMailUseCase(FindOfferRepository findOfferRepository, LinksService linksService, EmailGenerator emailGenerator, @Qualifier("sendgrid") EmailSender emailSender) {
        this.offerRepository = findOfferRepository;
        this.linksService = linksService;
        this.emailGenerator = emailGenerator;
        this.emailSender = emailSender;
    }

    public void send(OfferId offerId) throws NullOfferConfirmationException, UnableToSendEmailException, JsonProcessingException {
        Offer foundOffer = offerRepository.find(offerId).orElseThrow(() -> new OfferNotFoundException(MessageFormat.format("Offer with id {0} not found", offerId.value())));

        PairLinks pairLinks = linksService.generatePairLinksBy(foundOffer);

        OfferConfirmationParameters offerConfirmationParameters = new OfferConfirmationParameters(
                foundOffer.getTitle(),
                foundOffer.getDescription(),
                foundOffer.getUser().getUsername(),
                foundOffer.getAddress().toString(),
                foundOffer.getAvailabilityDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                foundOffer.getExpirationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                pairLinks.validateLink().value(),
                pairLinks.rejectLink().value()
        );

        String emailBody = emailGenerator.generateEmailFromTemplate(offerConfirmationParameters);

        emailSender.send(new EmailInformation(Email.builder().value(foundOffer.getUser().getEmail().getValue()).build(),
                Email.builder().value(EMAIL_SENDER).build(),
                CONFIRMATION_EMAIL_SUBJECT,
                emailBody));
    }
}
