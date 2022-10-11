package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.Offer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OfferAdapterTest {

    @Mock
    private OfferJpaRepository offerJpaRepository;

    @Test
    void should_save_offer() {
        var offer = Offer.builder().build();
        var offersAdapter = new OffersAdapter(offerJpaRepository);

        var offerId = offersAdapter.save(offer);

        //Mockito.verify(offerJpaRepository, times(1)).save(offer);

    }

}