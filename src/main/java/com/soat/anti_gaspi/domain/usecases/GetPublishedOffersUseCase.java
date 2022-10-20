package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.FindOfferRepository;
import com.soat.anti_gaspi.domain.Offer;

import java.util.List;

public class GetPublishedOffersUseCase {

    private final FindOfferRepository finder;

    public GetPublishedOffersUseCase(FindOfferRepository finder) {
        this.finder = finder;
    }

    public List<Offer> get() {
        return finder.findPublished();
    }
}
