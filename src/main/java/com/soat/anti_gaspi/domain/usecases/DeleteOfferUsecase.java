package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.FindOfferRepository;
import com.soat.anti_gaspi.domain.OfferRepository;
import com.soat.anti_gaspi.domain.exception.OfferNotFoundException;

public class DeleteOfferUsecase {

    private final OfferRepository repository;
    private final FindOfferRepository offerFinder;

    public DeleteOfferUsecase(OfferRepository repository, FindOfferRepository offerFinder) {
        this.repository = repository;
        this.offerFinder = offerFinder;
    }

    public void delete(String hash) {
        var offer = offerFinder.findOfferByHash(hash);

        if (offer.isEmpty()) {
            throw new OfferNotFoundException("");
        }

        var offerFound = offer.get();

        offerFound.delete();
        repository.update(offerFound);
    }
}
