package com.soat.anti_gaspi.infrastructure.repositories.offers;

import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.infrastructure.repositories.mapper.StatusMapper;
import com.soat.anti_gaspi.model.OfferEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.time.OffsetDateTime;
import java.util.List;

public class OfferHelper {
    public static Offer getOffer(final String id, final String email,
                                 final String number, final OffsetDateTime availabilityDate,
                                 final OffsetDateTime expirationDate, final Status status) {
        return Offer.builder().offerId(
                        new OfferId(id)).user(User.builder()
                        .email(Email.builder().value(email).build())
                        .build())
                .address(Address.builder().number(NumberIndicator.builder().number(number).build())
                        .build())
                .availabilityDate(availabilityDate)
                .expirationDate(expirationDate)
                .status(status)
                .build();
    }

    public static MapSqlParameterSource getOfferAsSqlMapProperties(final String id, final String email,
                                                                   final String number, final OffsetDateTime availabilityDate,
                                                                   final OffsetDateTime expirationDate, final Status status) {
        return new MapSqlParameterSource()
                .addValue("natural_id", id)
                .addValue("email", email)
                .addValue("number", number)
                .addValue("availability_date", availabilityDate.toLocalDate())
                .addValue("expiration_date", expirationDate.toLocalDate())
                .addValue("status", status.getValue());
    }

    public static List<OfferEntity> getOffersEntity(String query, final MapSqlParameterSource parameters, NamedParameterJdbcTemplate jdbcTemplate) {
        return jdbcTemplate.query(
                query,
                parameters,
                (resultSet, rowNum) ->
                        OfferEntity.builder()
                                .title(resultSet.getString("title"))
                                .email(resultSet.getString("email"))
                                .description(resultSet.getString("description"))
                                .naturalId(resultSet.getString("natural_id"))
                                .id(resultSet.getString("id"))
                                .city(resultSet.getString("city"))
                                .country(resultSet.getString("country"))
                                .number(resultSet.getString("number"))
                                .street(resultSet.getString("street"))
                                .zipCode(resultSet.getString("zipcode"))
                                .availabilityDate(resultSet.getDate("availability_date").toLocalDate().atTime(0, 0))
                                .expirationDate(resultSet.getDate("expiration_date").toLocalDate().atTime(0, 0))
                                .status(resultSet.getString("status"))
                                .build()
        );
    }

    public static void insertOffer(NamedParameterJdbcTemplate jdbcTemplate, MapSqlParameterSource parameters) {
        jdbcTemplate.update("""
                        insert into OFFER
                        (natural_id, email, number, availability_date, expiration_date, status) VALUES(
                        :natural_id, :email, :number, :availability_date, :expiration_date, :status)""",
                parameters);
    }

    public static void DropOffers(NamedParameterJdbcTemplate jdbcTemplate) {
        jdbcTemplate.update("delete from OFFER", new MapSqlParameterSource());
    }
}