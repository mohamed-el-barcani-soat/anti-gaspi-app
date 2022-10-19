package com.soat.anti_gaspi.config;

import com.soat.anti_gaspi.domain.FindOfferRepository;
import com.soat.anti_gaspi.domain.LinksService;
import com.soat.anti_gaspi.domain.OfferIdHashRepository;
import com.soat.anti_gaspi.domain.usecases.SendConfirmationMailUseCase;
import com.soat.anti_gaspi.infrastructure.email.ThymeLeafEmailGenerator;
import com.soat.anti_gaspi.infrastructure.mail_sender.GmailEmailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



// Supprimer ? Pour le moment le code n'est pas appelé
@Configuration
public class MailSenderConfig {

    @Bean
    SendConfirmationMailUseCase sendConfirmationMailUseCase(FindOfferRepository findOfferRepository, OfferIdHashRepository offerIdHashRepository, LinksService linksService, ThymeLeafEmailGenerator emailGenerator, GmailEmailSender mailSender) {
        return new SendConfirmationMailUseCase(findOfferRepository, offerIdHashRepository, linksService, emailGenerator, mailSender);
    }
}