package com.soat.anti_gaspi.domain.usecases;


import com.soat.anti_gaspi.domain.EmailSender;
import com.soat.anti_gaspi.domain.OfferConfirmationRepository;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.exception.OfferNotFoundException;
import com.soat.anti_gaspi.infrastructure.email.EmailGenerator;
import com.soat.anti_gaspi.infrastructure.email.FakeEmailGenerator;
import com.soat.anti_gaspi.infrastructure.repositories.email.FakeOfferRepositorySendConfirmationMail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.MessageFormat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class SendConfirmationMailUseCaseTest {
    private SendConfirmationMailUseCase sendConfirmationMailUseCase;
    EmailGenerator fakeEmailGenerator = new FakeEmailGenerator();

    OfferConfirmationRepository fakeOfferRepository;
    @Mock
    EmailSender mockEmailSender;

    @BeforeEach
    void setup() {
        fakeOfferRepository = new FakeOfferRepositorySendConfirmationMail();
        sendConfirmationMailUseCase = new SendConfirmationMailUseCase(fakeOfferRepository, fakeEmailGenerator, mockEmailSender);
    }

    @Test
    void should_throw_exception_when_offer_not_found_by_id() {
        var offerId = new OfferId("97UHIUG8I7G8G");

        assertThatThrownBy(() -> sendConfirmationMailUseCase.send("97UHIUG8I7G8G"))
                .isExactlyInstanceOf(OfferNotFoundException.class)
                .hasMessage(MessageFormat.format("Offer with id {0} not found", offerId.value()));
    }

    @Test
    void should_generate_validation_link(){

    }
}