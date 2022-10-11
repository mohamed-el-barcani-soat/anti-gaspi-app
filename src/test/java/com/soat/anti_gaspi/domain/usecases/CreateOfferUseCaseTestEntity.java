package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CreateOfferUseCaseTestEntity {

    private CreateOfferUseCase createOffer;

    private OfferRepository offers = new FakeOffersAdapter();

    @Test
    void should_return_created_offer_UUID(){


        createOffer = new CreateOfferUseCase(offers);
        OfferId offerId = new OfferId("fakeId");
        Offer offer = Offer.builder().id(offerId).build();

        String uuid = createOffer.create(offer);

        assertThat(uuid).isEqualTo("fakeId");
    }
}