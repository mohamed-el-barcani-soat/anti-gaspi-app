package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.FindPublishedOffersRepository;
import com.soat.anti_gaspi.domain.Offer;

import java.util.List;

public class GetPublishedOffersUseCase {

    private final FindPublishedOffersRepository finder;

    public GetPublishedOffersUseCase(FindPublishedOffersRepository finder) {
        this.finder = finder;
    }

    public List<Offer> get() {
        return finder.findAllPublished();
    }
}
