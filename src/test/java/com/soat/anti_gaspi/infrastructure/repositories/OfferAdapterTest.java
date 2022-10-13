package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.infrastructure.mappers.OfferMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class OfferAdapterTest {

    @Autowired
    private OfferJpaRepository offerJpaRepository;

    @Test
    void should_save_offer() {
        var offer = Offer.builder().offerId(
                        new OfferId("id")).user(User.builder()
                        .email(Email.builder().value("email@email.com").build())
                        .build())
                .address(Address.builder().number(NumberIndicator.builder().number("1").build())
                        .build())
                .availabilityDate(OffsetDateTime.now())
                .expirationDate(OffsetDateTime.now())
                .status(Status.PENDING)
                .build();
        OfferMapper offerMapper = new OfferMapper();

        var offersAdapter = new OffersAdapter(offerJpaRepository, offerMapper);

        var offerId = offersAdapter.save(offer);

        assertThat(offerId.naturalId()).isEqualTo("id");

        var result = offerJpaRepository.findByNaturalId(offerId.naturalId());

        assertThat(result.getTitle()).isEqualTo(offer.getTitle());
        assertThat(result.getDescription()).isEqualTo(offer.getDescription());
        assertThat(result.getEmail()).isEqualTo(offer.getUser().getEmail().getValue());
        assertThat(result.getNumber()).isEqualTo(offer.getAddress().getNumber());
        assertThat(result.getStreet()).isEqualTo(offer.getAddress().getStreet());
        assertThat(result.getCity()).isEqualTo(offer.getAddress().getCity());
        assertThat(result.getZipCode()).isEqualTo(offer.getAddress().getZipCode());
        assertThat(result.getCountry()).isEqualTo(offer.getAddress().getCountry());
        assertThat(result.getAvailabilityDate()).isEqualTo(offer.getAvailabilityDate().toLocalDateTime());
        assertThat(result.getExpirationDate()).isEqualTo(offer.getExpirationDate().toLocalDateTime());
        assertThat(result.getStatus()).isEqualTo(offer.getStatus());
    }

}