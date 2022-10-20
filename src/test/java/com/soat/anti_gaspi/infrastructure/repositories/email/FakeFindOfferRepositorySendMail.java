package com.soat.anti_gaspi.infrastructure.repositories.email;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.FindOfferRepository;
import com.soat.anti_gaspi.domain.OfferId;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FakeFindOfferRepositorySendMail implements FindOfferRepository {

    @Override
    public Optional<Offer> find(OfferId offerId) {
        return Optional.empty();
    }

}
