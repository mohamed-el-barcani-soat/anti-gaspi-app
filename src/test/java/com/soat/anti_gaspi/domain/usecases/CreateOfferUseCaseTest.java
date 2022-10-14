package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.Offers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CreateOfferUseCaseTest {

    private CreateOfferUseCase createOffer;

    private Offers offers = new FakeOffersAdapter();

    @Test
    void should_return_created_offer_UUID(){


        createOffer = new CreateOfferUseCase(offers);
        OfferId offerId = new OfferId("fakeId");
        Offer offer = Offer.builder().offerId(offerId).build();

        String uuid = createOffer.create(offer);

        assertThat(uuid).isEqualTo("fakeId");
    }
}