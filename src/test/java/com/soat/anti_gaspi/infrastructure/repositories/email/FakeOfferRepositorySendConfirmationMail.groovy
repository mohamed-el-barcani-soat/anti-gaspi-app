package com.soat.anti_gaspi.infrastructure.repositories.email

import com.soat.anti_gaspi.domain.Offer
import com.soat.anti_gaspi.domain.OfferId
import com.soat.anti_gaspi.domain.OfferRepository
// TODO : move to one class that contain all fake offer repository
class FakeOfferRepositorySendConfirmationMail implements OfferRepository{


    @Override
    OfferId create(Offer entity) {
        return null
    }

    @Override
    Optional<Offer> update(Offer entity) {
        return null
    }

    @Override
    void delete(Offer entity) {

    }

    @Override
    Optional<Offer> find(OfferId offerId) {
        return Optional.empty();
    }
}
