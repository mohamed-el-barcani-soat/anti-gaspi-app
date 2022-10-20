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
        var offer = Offer.builder().offerId(new OfferId("1234"))
                .build();
        var pairLinks = linksService.generatePairLinksBy(offer);

        assertThat(pairLinks).isNotNull();
        assertThat(pairLinks.rejectLink()).isNotNull();
        assertThat(pairLinks.rejectLink().value()).contains("/api/offers/delete?hash=");
        var rejectLinkValue = pairLinks.rejectLink().value();
        var rejectLinkHashValue = rejectLinkValue.substring(rejectLinkValue.indexOf("/api/offers/delete?hash=") + "/api/offers/delete?hash=".length());
        assertThat(rejectLinkHashValue).isNotBlank();

        assertThat(pairLinks.validateLink()).isNotNull();
        assertThat(pairLinks.validateLink().value()).contains("/api/offers/validate?hash=");
        var validateLinkValue = pairLinks.validateLink().value();
        var validateLinkHashValue = validateLinkValue.substring(validateLinkValue.indexOf("/api/offers/validate?hash=") + "/api/offers/validate?hash=".length());
        assertThat(validateLinkHashValue).isNotBlank();
    }
}