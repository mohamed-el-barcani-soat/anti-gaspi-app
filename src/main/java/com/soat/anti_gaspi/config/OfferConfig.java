package com.soat.anti_gaspi.config;

import com.soat.anti_gaspi.domain.usecases.CreateOffer;
import com.soat.anti_gaspi.infrastructure.repositories.OffersRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferConfig {

    @Bean
    CreateOffer createOfferFactory(OffersRepository offersRepository) {
        return new CreateOffer(offersRepository);
    }
}
