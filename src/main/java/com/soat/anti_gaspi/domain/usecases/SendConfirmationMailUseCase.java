package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.domain.exception.OfferNotFoundException;
import com.soat.anti_gaspi.infrastructure.email.EmailGenerator;
import com.soat.anti_gaspi.infrastructure.email.OfferConfirmationParameters;
import com.soat.anti_gaspi.infrastructure.email.exception.NullOfferConfirmationException;

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

    public void send(OfferId offerId) throws NullOfferConfirmationException {
        Offer foundOffer = offerRepository.find(offerId).orElseThrow(() -> new OfferNotFoundException(MessageFormat.format("Offer with id {0} not found", offerId.value())));

        // TODO : create and call link service to get pair of link that generate token and links

        PairLinks pairLinks = linksService.generatePairLinksBy(foundOffer);

        // TODO : with links and offer info generate email body

        OfferConfirmationParameters offerConfirmationParameters = new OfferConfirmationParameters(
                foundOffer.getTitle(),
                foundOffer.getDescription(),
                foundOffer.getUser().getEmail().getValue(),
                foundOffer.getAddress().toString(),
                foundOffer.getAvailabilityDate().toString(),
                foundOffer.getExpirationDate().toString(),
                pairLinks.validateLink().value(),
                pairLinks.rejectLink().value()
        );

        String emailBody = emailGenerator.generateEmailFromTemplate(offerConfirmationParameters);
        
        System.out.println(emailBody);
    }
}
