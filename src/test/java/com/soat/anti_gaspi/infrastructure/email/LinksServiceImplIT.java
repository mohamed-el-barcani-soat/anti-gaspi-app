package com.soat.anti_gaspi.infrastructure.email;

import com.soat.anti_gaspi.domain.Hash;
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
        var hash = new Hash("1234");
        var pairLinks = linksService.generateLinkBy(hash);

        assertThat(pairLinks).isNotNull();
        assertThat(pairLinks.rejectLink()).isNotNull();
        assertThat(pairLinks.rejectLink().value()).contains("/api/reject?hash=1234");

        assertThat(pairLinks.validateLink()).isNotNull();
        assertThat(pairLinks.validateLink().value()).contains("/api/validate?hash=1234");
    }
}