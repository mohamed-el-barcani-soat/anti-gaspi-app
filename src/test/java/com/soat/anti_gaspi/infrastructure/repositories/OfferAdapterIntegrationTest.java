package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.infrastructure.repositories.mapper.StatusMapper;
import com.soat.anti_gaspi.infrastructure.mappers.OfferMapper;
import com.soat.anti_gaspi.model.OfferEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.Clock;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*@Sql({
        "classpath:sql_scripts/offer.sql"
}) */
@SpringBootTest
class OfferAdapterIntegrationTest {

    @Autowired
    private OfferJpaRepository offerJpaRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final OfferMapper offerMapper = new OfferMapper();

    private final OfferRepositoryAdapter offersAdapter = new OfferRepositoryAdapter(offerJpaRepository, offerMapper);


    @Test
    void should_create() {


        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());//TODO DATE EN DURE
        Offer validOffer = OfferHelper.getValidOffer("id","email@email.fr","1",OffsetDateTime.now(clock), OffsetDateTime.now(clock),Status.PENDING);

        var offerId = offersAdapter.create(validOffer);

        assertThat(offerId.value()).isEqualTo("id");
        List<OfferEntity> offers = jdbcTemplate.query(
                "select * from offer where natural_id = 'id'",
                (resultSet, rowNum) -> {
                    return OfferEntity.OfferEntityBuilder.builder()
                            .title(resultSet.getString("title"))
                            .email(resultSet.getString("email"))
                            .description(resultSet.getString("description"))
                            .naturalId(resultSet.getString("natural_id"))
                            .id(resultSet.getString("id"))
                            .cityAddress(resultSet.getString("city"))
                            .country(resultSet.getString("country"))
                            .numberAddress(resultSet.getString("number"))
                            .streetAddress(resultSet.getString("street"))
                            .zipCodeAddress(resultSet.getString("zip_code"))
                            .availabilityDate(resultSet.getDate("availability_date").toLocalDate().atTime(0, 0))
                            .expirationDate(resultSet.getDate("expiration_date").toLocalDate().atTime(0, 0))
                            .status(StatusMapper.map(resultSet.getString("status")).get())

                            .build();


                });

        System.out.println(offers);

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
        assertThat(result.getStatus()).isEqualTo(validOffer.getStatus());
    }

    @Test
    void should_throw_error_offer_on_identical_natural_id() {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        Offer validOffer = OfferHelper.getValidOffer("id","email@email.fr","1",OffsetDateTime.now(clock), OffsetDateTime.now(clock),Status.PENDING);

        var offersAdapter = new OfferRepositoryAdapter(offerJpaRepository, offerMapper);

        var offerId = offersAdapter.create(validOffer);//TODO DISTINGUER CREATE UPDATE

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            var offerId2 = offersAdapter.create(validOffer);
        });
    }

    @Test
    void should_update_offer() {
        var offersAdapter = new OfferRepositoryAdapter(offerJpaRepository, offerMapper);
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        Offer validOffer = OfferHelper.getValidOffer("id","email@email.fr","1",OffsetDateTime.now(clock), OffsetDateTime.now(clock),Status.PENDING);

        var offerId = offersAdapter.create(validOffer); //TODO USE JDBC

        assertThat(offerId.value()).isEqualTo("id");

        var result = offerJpaRepository.findByNaturalId(offerId.value());

        var modifiedOffer = Offer.builder().offerId(
                        new OfferId("id")).user(User.builder()
                        .email(Email.builder().value("emailModifié@emailmodifié.com").build())
                        .build())
                .address(Address.builder().number(NumberIndicator.builder().number("1 bis").build())
                        .build())
                .availabilityDate(OffsetDateTime.now(clock))
                .expirationDate(OffsetDateTime.now(clock))
                .status(Status.PENDING)
                .build();

        offersAdapter.update(modifiedOffer);
    }

}