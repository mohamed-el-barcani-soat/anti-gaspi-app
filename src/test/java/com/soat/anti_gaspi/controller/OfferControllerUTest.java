package com.soat.anti_gaspi.controller;

import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

import com.dumbster.smtp.SimpleSmtpServer;
import com.soat.anti_gaspi.domain.usecases.CreateOfferUseCase;
import com.soat.anti_gaspi.infrastructure.repositories.ContactJpaRepository;
import com.soat.anti_gaspi.model.NotificationException;
import com.soat.anti_gaspi.infrastructure.repositories.OfferJpaRepository;
import com.soat.anti_gaspi.service.EmailService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.http.HttpStatus.*;

@ExtendWith(MockitoExtension.class)
class OfferControllerUTest {

    private OfferController offerController;

    @Mock
    private OfferJpaRepository offerRepository;

    @Mock
    private ContactJpaRepository contactRepository;

    @Mock
    private EmailService smailService;

    @Mock
    private CreateOfferUseCase createOffer;

    private final Clock clock = Clock.fixed(LocalDate.parse("2022-07-28").atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.of("UTC"));;


    public static final int SMTP_PORT = 9999;
    private SimpleSmtpServer mailServer;

    @BeforeEach
    void setUp() throws IOException {
        offerController = new OfferController(smailService, offerRepository, contactRepository, clock, createOffer);
        mailServer = SimpleSmtpServer.start(SMTP_PORT);
    }

    @AfterEach
    void tearDown() {
        mailServer.stop();
    }

    @Nested
    class CreateContact{
        @Test
        void should_return_bad_request_when_empty_firstname() throws NotificationException {
            // given
            ContactToSave contactToSave = new ContactToSave("Dupond", "", "0712345678", "contact@soat.fr", "lorem ipsum", "9c1845ea-a7be-4848-aba4-66ba33fd6d39");

            // when
            ResponseEntity<UUID> result = offerController.createContact(UUID.fromString("9c1845ea-a7be-4848-aba4-66ba33fd6d40"), contactToSave);

            // then
            assertThat(result.getStatusCode()).isEqualTo(BAD_REQUEST);
        }

        @Test
        void should_return_bad_request_when_empty_lastname() throws NotificationException {
            // given
            ContactToSave contactToSave = new ContactToSave("", "Martin", "0712345678", "contact@soat.fr", "lorem ipsum", "9c1845ea-a7be-4848-aba4-66ba33fd6d39");

            // when
            ResponseEntity<UUID> result = offerController.createContact(UUID.fromString("9c1845ea-a7be-4848-aba4-66ba33fd6d40"), contactToSave);

            // then
            assertThat(result.getStatusCode()).isEqualTo(BAD_REQUEST);
        }
        @Test
        void should_return_bad_request_when_invalid_email() throws NotificationException {
            // given
            ContactToSave contactToSave = new ContactToSave("Dupond", "Martin", "0712345678", "revendeur@invalid-email", "lorem ipsum", "9c1845ea-a7be-4848-aba4-66ba33fd6d39");

            // when
            ResponseEntity<UUID> result = offerController.createContact(UUID.fromString("9c1845ea-a7be-4848-aba4-66ba33fd6d40"), contactToSave);

            // then
            assertThat(result.getStatusCode()).isEqualTo(BAD_REQUEST);
        }

        @Test
        void should_return_bad_request_when_invalid_Num_Phone() throws NotificationException {
            // given
            ContactToSave contactToSave = new ContactToSave("Dupond", "Martin", "=712345678", "revendeur@invalid-email", "lorem ipsum", "9c1845ea-a7be-4848-aba4-66ba33fd6d39");

            // when
            ResponseEntity<UUID> result = offerController.createContact(UUID.fromString("9c1845ea-a7be-4848-aba4-66ba33fd6d40"), contactToSave);

            // then
            assertThat(result.getStatusCode()).isEqualTo(BAD_REQUEST);
        }

    }

}
