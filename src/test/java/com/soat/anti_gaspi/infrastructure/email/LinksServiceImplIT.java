package com.soat.anti_gaspi.infrastructure.email;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class LinksServiceImplIT {
    @Autowired
    private LinksServiceImpl linksService;

    @Test
    void should_generate_validate_and_reject_links_with_hash_in_query_params() {
        var offer = Offer.builder().offerId(new OfferId("1234")).build();
        var pairLinks = linksService.generateLinkBy(offer);

        assertThat(pairLinks).isNotNull();
        assertThat(pairLinks.rejectLink()).isNotNull();
        assertThat(pairLinks.rejectLink().value()).contains("/api/offers/reject?hash=1234");

        assertThat(pairLinks.validateLink()).isNotNull();
        assertThat(pairLinks.validateLink().value()).contains("/api/offers/validate?hash=1234");
    }
}