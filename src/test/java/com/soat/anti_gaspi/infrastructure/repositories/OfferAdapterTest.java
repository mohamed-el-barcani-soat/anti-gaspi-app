package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.infrastructure.mappers.OfferMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.OffsetDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class OfferAdapterTest { //TODO ADD INTEGRATION TO CLASS NAME

    @Autowired
    private OfferJpaRepository offerJpaRepository;

    private final OffsetDateTime now = OffsetDateTime.now();//TODO IMPL CLOCK


    private final Offer validOffer = Offer.builder().offerId( // SORTIR DANS UNE CLASSE POUR BUILD
                    new OfferId("id")).user(User.builder()
                    .email(Email.builder().value("email@email.com").build())
                    .build())
            .address(Address.builder().number(NumberIndicator.builder().number("1").build())
                    .build())
            .availabilityDate(now)
            .expirationDate(now)
            .status(Status.PENDING)
            .build();

    private final OfferMapper offerMapper = new OfferMapper();


    @Test
    void should_create() {

        var offersAdapter = new OffersAdapter(offerJpaRepository, offerMapper); //TODO PASSER EN CLASS

        var offerId = offersAdapter.create(validOffer);

        assertThat(offerId.value()).isEqualTo("id");

        var result = offerJpaRepository.findByNaturalId(offerId.value()); //TODO UTILISER LE JDBC TEMPLATE

        assertThat(result.getTitle()).isEqualTo(validOffer.getTitle());
        assertThat(result.getDescription()).isEqualTo(validOffer.getDescription());
        assertThat(result.getEmail()).isEqualTo(validOffer.getUser().getEmail().getValue());
        assertThat(result.getNumber()).isEqualTo(validOffer.getAddress().getNumber());
        assertThat(result.getStreet()).isEqualTo(validOffer.getAddress().getStreet());
        assertThat(result.getCity()).isEqualTo(validOffer.getAddress().getCity());
        assertThat(result.getZipCode()).isEqualTo(validOffer.getAddress().getZipCode());
        assertThat(result.getCountry()).isEqualTo(validOffer.getAddress().getCountry());
        assertThat(result.getAvailabilityDate().toLocalDate()).isEqualTo(validOffer.getAvailabilityDate().toLocalDate());
        assertThat(result.getExpirationDate().toLocalDate()).isEqualTo(validOffer.getExpirationDate().toLocalDate());
        assertThat(result.getStatus()).isEqualTo(validOffer.getStatus());
    }

    @Test
    void should_throw_error_offer_on_identical_natural_id() {

        var offersAdapter = new OffersAdapter(offerJpaRepository, offerMapper);

        var offerId = offersAdapter.create(validOffer);//TODO DISTINGUER CREATE UPDATE

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
                var offerId2 = offersAdapter.create(validOffer);
        });
    }

    @Test
    void should_update_offer() {
        var offersAdapter = new OffersAdapter(offerJpaRepository, offerMapper);

        var offerId = offersAdapter.create(validOffer); //TODO USE JDBC

        assertThat(offerId.value()).isEqualTo("id");

        var result = offerJpaRepository.findByNaturalId(offerId.value());

        var modifiedOffer = Offer.builder().offerId(
                        new OfferId("id")).user(User.builder()
                        .email(Email.builder().value("emailModifié@emailmodifié.com").build())
                        .build())
                .address(Address.builder().number(NumberIndicator.builder().number("1 bis").build())
                        .build())
                .availabilityDate(now)
                .expirationDate(now)
                .status(Status.PENDING)
                .build();

        offersAdapter.update(modifiedOffer);






    }

}