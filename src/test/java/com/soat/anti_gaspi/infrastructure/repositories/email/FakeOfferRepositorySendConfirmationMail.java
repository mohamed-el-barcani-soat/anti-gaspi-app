package com.soat.anti_gaspi.infrastructure.repositories.email;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferConfirmationRepository;
import com.soat.anti_gaspi.domain.OfferId;

import java.util.Optional;

public class FakeOfferRepositorySendConfirmationMail implements OfferConfirmationRepository{

    @Override
    public Optional<Offer> find(OfferId offerId) {
        return Optional.empty();
    }
}
