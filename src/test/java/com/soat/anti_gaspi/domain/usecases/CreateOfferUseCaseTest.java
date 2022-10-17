package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CreateOfferUseCaseTest {

    private CreateOfferUseCase createOffer;

    private OfferRepository offerRepository = new FakeOfferRepositoryAdapter();

    @Test
    void should_return_created_offer_UUID(){


        createOffer = new CreateOfferUseCase(offerRepository);
        OfferId offerId = new OfferId("fakeId");
        Offer offer = Offer.builder().offerId(offerId).build();

        String uuid = createOffer.create(offer);

        assertThat(uuid).isEqualTo("fakeId");
    }
}