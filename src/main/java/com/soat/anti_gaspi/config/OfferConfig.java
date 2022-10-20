package com.soat.anti_gaspi.config;

import com.soat.anti_gaspi.domain.usecases.*;
import com.soat.anti_gaspi.infrastructure.repositories.OfferAdapter;
import com.soat.anti_gaspi.infrastructure.repositories.OfferKeyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferConfig {

    @Bean
    CreateOfferUseCase createOfferFactory(OfferAdapter offersRepository) {
        return new CreateOfferUseCase(offersRepository);
    }

    @Bean
    GetOfferUseCase getOfferFactory(OfferAdapter offersRepository) {
        return new GetOfferUseCase(offersRepository);
    }

    @Bean
    GetPublishedOffersUseCase getPublishedOffersFactory(OfferAdapter offerFinder) {
        return new GetPublishedOffersUseCase(offerFinder);
    }


    @Bean
    PublishOfferUseCase publishOfferFactory(OfferAdapter offerAdapter, OfferKeyRepository offerKeyRepository) {
        return new PublishOfferUseCase(offerAdapter, offerAdapter, offerKeyRepository);
    }

    @Bean
    DeleteOfferUsecase deleteOfferFactory(OfferAdapter adapter) {
        return new DeleteOfferUsecase(adapter, adapter);
    }
}
