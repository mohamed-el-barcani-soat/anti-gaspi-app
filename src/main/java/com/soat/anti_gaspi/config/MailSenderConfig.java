package com.soat.anti_gaspi.config;

import com.soat.anti_gaspi.domain.EmailSender;
import com.soat.anti_gaspi.domain.FindOfferRepository;
import com.soat.anti_gaspi.domain.LinksService;
import com.soat.anti_gaspi.domain.usecases.SendConfirmationMailUseCase;
import com.soat.anti_gaspi.infrastructure.email.ThymeLeafEmailGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MailSenderConfig {
    @Bean
    SendConfirmationMailUseCase sendConfirmationMailUseCase(FindOfferRepository findOfferRepository, LinksService linksService, ThymeLeafEmailGenerator emailGenerator, EmailSender mailSender) {
        return new SendConfirmationMailUseCase(findOfferRepository, linksService, emailGenerator, mailSender);
    }
}