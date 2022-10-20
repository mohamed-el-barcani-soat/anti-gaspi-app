package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.Offer;

import java.util.List;

public interface OfferFinder {
    List<Offer> findPublished();
}
