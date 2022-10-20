package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.FindOfferRepository;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferKeyFinder;
import com.soat.anti_gaspi.domain.OfferRepository;
import com.soat.anti_gaspi.domain.exception.OfferKeyNotFoundException;
import com.soat.anti_gaspi.domain.exception.OfferNotFoundException;

public class PublishOfferUseCase {

    private final FindOfferRepository offerFinder;
    private final OfferRepository repository;

    private final OfferKeyFinder offerKeyFinder;

    public PublishOfferUseCase(OfferRepository repository, FindOfferRepository offerFinder, OfferKeyFinder offerKeyFinder) {
        this.repository = repository;
        this.offerFinder = offerFinder;
        this.offerKeyFinder = offerKeyFinder;
    }

    public void publish(OfferId id) {
        var offer = offerFinder.find(id);

        if (offer.isEmpty()) {
            throw new OfferNotFoundException("");
        }

        var offerFound = offer.get();

        offerKeyFinder.findByOfferId(offerFound.getOfferId())
                .ifPresentOrElse((key) -> {
                            offerFound.publish(key);
                            repository.update(offerFound);
                        },
                        () -> {
                            throw new OfferKeyNotFoundException("Offer not found");
                        });
    }
}
