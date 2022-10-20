package com.soat.anti_gaspi.application.offer.mappers;

import static org.assertj.core.api.Assertions.assertThat;


class OfferMapperTest {
    /*

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final String validCompanyName = "Soat";
    private final String validTitle = "table";
    private final String validDescription = "une table bien";
    private final String validEmail = "soat@table.fr";
    private final String validAddress = "chez moi";
    private final String validAvailabilityDate = "2022-11-23";
    private final String validExpirationDate = "2023-11-23";

    private final OfferMapper mapper = new OfferMapper();
    @Test
    public void should_convert_on_valid_value() {
        OfferDto offerDto = new OfferDto(
                validCompanyName,
                validTitle,
                validDescription,
                validEmail,
                validAddress,
                validAvailabilityDate,
                validExpirationDate
        );

        var availabityLocalDate = LocalDate.parse(validAvailabilityDate, dateFormatter);
        var expirationLocalDate = LocalDate.parse(validExpirationDate, dateFormatter);
        var mapper = new OfferMapper();

        var offer = mapper.map(offerDto);
        //assertEquals("Id généré", offer.getOfferId().id());
        assertThat(validTitle).isEqualTo(offer.getTitle());
        assertThat(validDescription).isEqualTo(offer.getDescription());
        assertThat(validEmail).isEqualTo(offer.getEmail());
        assertThat(validAddress).isEqualTo(offer.getAddress());
        assertThat(availabityLocalDate).isEqualTo(offer.getAvailabilityDate());
        assertThat(expirationLocalDate).isEqualTo(offer.getExpirationDate());
    }

    @Test
    public void should_generate_valid_id_of_offer() {
        OfferDto offerDto = new OfferDto(
                validCompanyName,
                validTitle,
                validDescription,
                validEmail,
                validAddress,
                validAvailabilityDate,
                validExpirationDate
        );

        var offer = mapper.map(offerDto);

        var availabityLocalDate = LocalDate.parse(validAvailabilityDate, dateFormatter);

        var generatedId = availabityLocalDate.format(dateFormatter);

        assertThat("Id généré").isEqualTo(offer.getOfferId().id());
    }
    */

}