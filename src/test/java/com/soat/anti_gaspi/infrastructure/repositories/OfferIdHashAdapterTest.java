package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class OfferIdHashAdapterTest {

    private OfferIdHashAdapter offerIdHashAdapter;

    @BeforeEach
    void setup() {
        offerIdHashAdapter = new OfferIdHashAdapter((offer -> offer.getOfferId() + "hash"));
    }

    @Test
    void given_hash_when_no_offerid_associated_to_hash_should_return_empty_optional() {
        var maybeOfferId = offerIdHashAdapter.findOfferIdByHash(new Hash("unknown"));

        assertThat(maybeOfferId).isEmpty();
    }

    @Test
    void given_hash_when_one_offerid_associated_to_hash_should_return_optional_with_concerned_offerid() throws NoSuchAlgorithmException {
        var offerId = new OfferId("1234");
        var offer = Offer.builder().offerId(offerId).build();
        var hash = offerIdHashAdapter.updateWithHash(offer);

        var maybeOfferId = offerIdHashAdapter.findOfferIdByHash(hash);

        var result = maybeOfferId.orElseThrow();
        assertThat(result).isEqualTo(offerId);
    }
}