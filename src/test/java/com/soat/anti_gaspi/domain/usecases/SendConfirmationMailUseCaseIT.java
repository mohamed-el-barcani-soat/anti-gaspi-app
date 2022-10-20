package com.soat.anti_gaspi.domain.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.domain.exception.UnableToSendEmailException;
import com.soat.anti_gaspi.infrastructure.email.exception.NullOfferConfirmationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

@SpringBootTest
class SendConfirmationMailUseCaseIT {

    @Autowired
    private SendConfirmationMailUseCase sendConfirmationMailUseCase;

    @Autowired
    private OfferRepository offerRepository;

    @Test
    void test() throws NullOfferConfirmationException, UnableToSendEmailException, JsonProcessingException {
        OfferId offerId = new OfferId("1234");
        Offer offerToCreate = Offer.builder()
                .offerId(offerId)
                .title("title")
                .description("description")
                .user(User.builder()
                        .email(Email.builder().value("mohamed.el-barcani@soat.fr").build())
                        .username("username")
                        .build())
                .address(Address.builder()
                        .number(NumberIndicator.builder().number("234").build())
                        .city("city")
                        .country("country")
                        .street("street")
                        .zipcode("zipcode")
                        .build())
                .availabilityDate(OffsetDateTime.now())
                .expirationDate(OffsetDateTime.now())
                .status(Status.PENDING)
                .build();
        offerRepository.create(offerToCreate);

        Offer offer = Offer.builder()
                .offerId(offerId)
                .title("title")
                .description("description")
                .user(User.builder()
                        .email(Email.builder().value("email@emalinksServiceil.com").build())
                        .username("username")
                        .build())
                .address(Address.builder()
                        .city("city")
                        .country("country")
                        .street("street")
                        .zipcode("zipcode")
                        .build())
                .availabilityDate(OffsetDateTime.now())
                .expirationDate(OffsetDateTime.now())
                .build();
        //when(findOfferRepository.find(offerId)).thenReturn(java.util.Optional.of(offer));

        sendConfirmationMailUseCase.send(offerId);
    }
}