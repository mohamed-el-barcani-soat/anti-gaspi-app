package com.soat.anti_gaspi.infrastructure.email;

import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.infrastructure.repositories.ConfirmationKeyOfferJpaRepository;
import com.soat.anti_gaspi.infrastructure.service.HashGenerator;
import com.soat.anti_gaspi.model.ConfirmationKeyOfferEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.text.MessageFormat;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class LinksServiceImpl implements LinksService {
    private static final String VALIDATE_TYPE_LINK = "validate";
    private static final String DELETE_TYPE_LINK = "delete";
    private final ConfirmationKeyOfferJpaRepository confirmationKeyOfferJpaRepository;

    private final HashGenerator hashGenerator;
    @Override
    public PairLinks generateLinkBy(Offer offer) {
        String hashKey = hashGenerator.generate(offer);
        ConfirmationKeyOfferEntity confirmationKeyOffer = ConfirmationKeyOfferEntity.builder()
                .key(hashKey)
                .creationDate(LocalDateTime.now())
                .offerId(offer.getOfferId().value())
                .build();
        ConfirmationKeyOfferEntity confirmationKeyOfferEntity = confirmationKeyOfferJpaRepository.save(confirmationKeyOffer);
        String appLink = ServletUriComponentsBuilder.fromCurrentContextPath()
                .build()
                .toUriString();
        var validateLink = new ValidateLink(generateLink(appLink, VALIDATE_TYPE_LINK, confirmationKeyOfferEntity.getKey()));
        var rejectLink = new RejectLink(generateLink(appLink, DELETE_TYPE_LINK, confirmationKeyOfferEntity.getKey()));
        return new PairLinks(validateLink, rejectLink);
    }

    private String generateLink(String appLink, String typeLink, String hash) {
        return MessageFormat.format("{0}/api/offers/{1}?hash={2}", appLink, typeLink, hash);
    }
}
