package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.FindOfferRepository;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferKeyFinder;
import com.soat.anti_gaspi.domain.OfferRepository;
import com.soat.anti_gaspi.domain.exception.OfferKeyNotFoundException;
import com.soat.anti_gaspi.domain.exception.OfferNotFoundException;

public class DeleteOfferUsecase {

    private final OfferRepository repository;
    private final FindOfferRepository offerFinder;

    public DeleteOfferUsecase(OfferRepository repository, FindOfferRepository offerFinder) {
        this.repository = repository;
        this.offerFinder = offerFinder;
    }

    public void delete(OfferId id) {
        var offer = offerFinder.find(id);

        if (offer.isEmpty()) {
            throw new OfferNotFoundException("");
        }

        var offerFound = offer.get();

        offerFound.delete();
        repository.update(offerFound);
    }
}
