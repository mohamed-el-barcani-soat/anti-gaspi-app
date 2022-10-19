package com.soat.anti_gaspi.config;

import com.soat.anti_gaspi.domain.OfferRepository;
import com.soat.anti_gaspi.domain.usecases.SendConfirmationMailUseCase;
import com.soat.anti_gaspi.infrastructure.email.ThymeLeafEmailGenerator;
import com.soat.anti_gaspi.infrastructure.mail_sender.GmailEmailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



// Supprimer ? Pour le moment le code n'est pas appelé
@Configuration
public class MailSenderConfig {

    // TODO : create interface to get for now the offer and not OfferRepository
    @Bean
    SendConfirmationMailUseCase sendConfirmationMailUseCase(OfferRepository offerRepository, ThymeLeafEmailGenerator emailGenerator, GmailEmailSender mailSender) {
        return new SendConfirmationMailUseCase(offerRepository, emailGenerator, mailSender);
    }
}