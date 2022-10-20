package com.soat.anti_gaspi.infrastructure.service;

import com.soat.anti_gaspi.domain.Offer;

public interface HashGenerator {
    String generate(Offer offer);
}
