package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.infrastructure.repositories.OffersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateOfferTest {

    private CreateOffer createOffer;

    @Mock
    private OffersRepository offersRepository;

    @Test
    void should_return_created_offer_UUID(){
        createOffer = new CreateOffer(offersRepository);
        OfferId offerId = new OfferId("id");
        Offer offer = Offer.builder().id(offerId).build();

        String uuid = createOffer.handle(offer);

        verify(offersRepository, times(1)).save(offer);
    }
}