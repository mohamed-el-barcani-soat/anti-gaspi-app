package com.soat.anti_gaspi.domain;

import java.util.List;

public interface FindPublishedOffersRepository {
    List<Offer> findAllPublished();
}
