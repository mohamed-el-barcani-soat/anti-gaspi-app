package com.soat.anti_gaspi.domain.usecases;


import com.soat.anti_gaspi.domain.EmailSender;
import com.soat.anti_gaspi.domain.OfferRepository;
import com.soat.anti_gaspi.infrastructure.email.EmailGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SendConfirmationMailUseCaseTest {
    private SendConfirmationMailUseCase sendConfirmationMailUseCase;
    EmailGenerator fakeEmailGenerator = new FakeEmailGenerator();

    OfferRepository fakeOfferRepository = new FakeOfferRepositoryAdapter();
    @Mock
    EmailSender mockEmailSender;

    @BeforeEach
    void setup() {
        sendConfirmationMailUseCase = new SendConfirmationMailUseCase(fakeEmailGenerator, mockEmailSender);
    }

    @Test
    void should_throw_exception_when_offer_not_found_by_id() {

    }
}