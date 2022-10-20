package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.infrastructure.service.HashGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class OfferTokenAdapterTest {

    private OfferIdHashAdapter offerTokenAdapter;

    @Mock
    private HashGenerator mockHashGenerator;

    @BeforeEach
    void setup() {
        offerTokenAdapter = new OfferIdHashAdapter(mockHashGenerator);
    }

    @Test
    void should_save_offerid_and_generated_token() throws NoSuchAlgorithmException {
        var hashValue = "hashValue";
        var offerIdValue = "offerid";
        var offer = Offer.builder().offerId(new OfferId(offerIdValue)).build();
        Mockito.when(mockHashGenerator.generate(offer)).thenReturn(hashValue);

        offerTokenAdapter.updateWithHash(offer);

        var maybeOfferId = offerTokenAdapter.findOfferIdByHash(new Hash(hashValue));
        assertThat(maybeOfferId).isNotNull();
        assertThat(maybeOfferId.get().value()).isEqualTo(offerIdValue);
    }
}