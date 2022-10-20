package com.soat.anti_gaspi.domain.usecases;


import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.domain.exception.OfferNotFoundException;
import com.soat.anti_gaspi.infrastructure.email.EmailGenerator;
import com.soat.anti_gaspi.infrastructure.email.FakeEmailGenerator;
import com.soat.anti_gaspi.infrastructure.repositories.Hash;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class SendConfirmationMailUseCaseTest {
    EmailGenerator fakeEmailGenerator = new FakeEmailGenerator();

    @Mock
    EmailSender mockEmailSender;

    @Test
    void should_throw_exception_when_offer_not_found_by_id() {
        var sendConfirmationMailUseCase = new SendConfirmationMailUseCase(
                var0 -> Optional.empty(),
                (offer) -> new PairLinks(new ValidateLink("http://validatelink.com"), new RejectLink("http://rejectlink.com"))
                ,
                fakeEmailGenerator,
                mockEmailSender);
        var offerId = new OfferId("97UHIUG8I7G8G");

        assertThatThrownBy(() -> sendConfirmationMailUseCase.send("97UHIUG8I7G8G"))
                .isExactlyInstanceOf(OfferNotFoundException.class)
                .hasMessage(MessageFormat.format("Offer with id {0} not found", offerId.value()));
    }

    @Test
    void should_update_offer_with_token() throws NoSuchAlgorithmException {
        var foundOffer = Offer.builder().offerId(new OfferId("id1")).build();
        var sendConfirmationMailUseCase = new SendConfirmationMailUseCase(
                var0 -> Optional.of(foundOffer),
                (offer) -> new PairLinks(new ValidateLink("http://validatelink.com"), new RejectLink("http://rejectlink.com")),
                fakeEmailGenerator,
                mockEmailSender);
        var newHash = new Hash("new hash");

    }
}