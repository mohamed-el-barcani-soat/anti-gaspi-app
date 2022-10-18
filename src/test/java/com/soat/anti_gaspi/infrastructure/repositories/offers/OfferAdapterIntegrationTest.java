package com.soat.anti_gaspi.infrastructure.repositories.offers;

import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.infrastructure.repositories.ClockHelper;
import com.soat.anti_gaspi.infrastructure.repositories.OfferAdapter;
import com.soat.anti_gaspi.infrastructure.repositories.OfferJpaRepository;
import com.soat.anti_gaspi.infrastructure.mappers.OfferMapper;
import com.soat.anti_gaspi.model.OfferEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*@Sql({
        "classpath:sql_scripts/offer.sql"
}) */
// TODO precise sql files instead of relying on spring natural introspection
@SpringBootTest
class OfferAdapterIntegrationTest {


    @Autowired()
    private OfferJpaRepository offerJpaRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @BeforeEach
    public void clean() {
        OfferHelper.DropOffers(jdbcTemplate);
    }

    private final OfferMapper offerMapper = new OfferMapper();

    @Test
    void should_create() {
        // Given
        var offersAdapter = new OfferAdapter(offerJpaRepository, offerMapper);
        var clock = ClockHelper.getClock();
        var id = "id";

        Offer validOffer = OfferHelper.getOffer(id, "email@email.fr", "1", OffsetDateTime.now(clock), OffsetDateTime.now(clock), Status.PENDING);


        // When
        var offerId = offersAdapter.create(validOffer);


        // Then
        assertThat(offerId.value()).isEqualTo(id);
        List<OfferEntity> offers = OfferHelper.getOffersEntity(
                "select * from offer where natural_id = :id",
                new MapSqlParameterSource(id, offerId.value()),
                jdbcTemplate);

        assertThat(offers.size()).isEqualTo(1);

        var result = offers.get(0);

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
        assertThat(result.getStatus()).isEqualTo(validOffer.getStatus().getValue());
    }

    @Test
    void should_throw_error_offer_on_identical_natural_id() {
        // Given
        var offersAdapter = new OfferAdapter(offerJpaRepository, offerMapper);
        var clock = ClockHelper.getClock();
        Offer validOffer = OfferHelper.getOffer("id", "email@email.fr", "1", OffsetDateTime.now(clock), OffsetDateTime.now(clock), Status.PENDING);


        //When
        var offerId = offersAdapter.create(validOffer);//TODO DISTINGUER CREATE UPDATE

        // Then
        var dataIntegrityViolationException = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            offersAdapter.create(validOffer);
        });
        assertThat(dataIntegrityViolationException.getMessage()).isEqualTo("could not execute statement; SQL [n/a]; constraint [null]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement");
    }

    @Test
    void should_update_offer() {
        // Given
        var offersAdapter = new OfferAdapter(offerJpaRepository, offerMapper);
        Clock clock = ClockHelper.getClock();
        OfferHelper.insertOffer(jdbcTemplate, OfferHelper.getOfferAsSqlMapProperties("id", "email@email.fr", "1", OffsetDateTime.now(clock), OffsetDateTime.now(clock), Status.PENDING));

        var modifiedOffer = OfferHelper.getOffer("id", "emailmodifié@email.fr", "1 bis", OffsetDateTime.now(clock), OffsetDateTime.now(clock), Status.PENDING);

        // When
        offersAdapter.update(modifiedOffer);

        // Then
        var offersById = OfferHelper
                .getOffersEntity("select * from offer where natural_id = :id",
                        new MapSqlParameterSource("id", "id"),
                        jdbcTemplate);

        assertThat(offersById.size()).isEqualTo(1);

        var modifiedOfferEntity = offersById.get(0);

        assertThat(modifiedOfferEntity.getTitle()).isEqualTo(modifiedOffer.getTitle());
        assertThat(modifiedOfferEntity.getDescription()).isEqualTo(modifiedOffer.getDescription());
        assertThat(modifiedOfferEntity.getEmail()).isEqualTo(modifiedOffer.getUser().getEmail().getValue());
        assertThat(modifiedOfferEntity.getNumber()).isEqualTo(modifiedOffer.getAddress().getNumber());
        assertThat(modifiedOfferEntity.getStreet()).isEqualTo(modifiedOffer.getAddress().getStreet());
        assertThat(modifiedOfferEntity.getCity()).isEqualTo(modifiedOffer.getAddress().getCity());
        assertThat(modifiedOfferEntity.getZipCode()).isEqualTo(modifiedOffer.getAddress().getZipCode());
        assertThat(modifiedOfferEntity.getCountry()).isEqualTo(modifiedOffer.getAddress().getCountry());
        assertThat(modifiedOfferEntity.getAvailabilityDate().toLocalDate()).isEqualTo(modifiedOffer.getAvailabilityDate().toLocalDate());
        assertThat(modifiedOfferEntity.getExpirationDate().toLocalDate()).isEqualTo(modifiedOffer.getExpirationDate().toLocalDate());
        assertThat(modifiedOfferEntity.getStatus()).isEqualTo(modifiedOffer.getStatus().getValue());
    }

}