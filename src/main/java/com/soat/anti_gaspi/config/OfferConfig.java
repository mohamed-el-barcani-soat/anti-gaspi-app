package com.soat.anti_gaspi.config;

import com.soat.anti_gaspi.domain.usecases.CreateOfferUseCase;
import com.soat.anti_gaspi.infrastructure.repositories.OfferRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferConfig {

    @Bean
    CreateOfferUseCase createOfferFactory(OfferRepositoryAdapter offersRepository) {
        return new CreateOfferUseCase(offersRepository);
    }
}
