package com.soat.anti_gaspi.config;

import com.soat.anti_gaspi.domain.usecases.CreateOfferUseCase;
import com.soat.anti_gaspi.infrastructure.repositories.OfferAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferConfig {

    @Bean
    CreateOfferUseCase createOfferFactory(FindOfferAdapter offersRepository) {
        return new CreateOfferUseCase(offersRepository);
    }

    @Bean
    GetOfferUseCase getOfferUseCase(OfferAdapter offersRepository) {
        return new GetOfferUseCase(offersRepository);
    }

    @Bean
    GetPublishedOffersUseCase getPublishedOffersUseCase(OfferFinder offerFinder) {
        return new GetPublishedOffersUseCase(offerFinder);
    }
}
