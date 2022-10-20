package com.soat.anti_gaspi.infrastructure.email;

import com.soat.anti_gaspi.domain.*;
import com.soat.anti_gaspi.infrastructure.repositories.Hash;
import com.soat.anti_gaspi.infrastructure.repositories.OfferIdHashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class LinksServiceImpl implements LinksService {
    private static final String VALIDATE_TYPE_LINK = "validate";
    private static final String REJECT_TYPE_LINK = "reject";
    private final OfferIdHashRepository offerIdHashRepository;
    @Override
    public PairLinks generateLinkBy(Offer offer) {
        Hash hash = offerIdHashRepository.updateWithHash(offer);
        String appLink = ServletUriComponentsBuilder.fromCurrentContextPath()
                .build()
                .toUriString();
        var validateLink = new ValidateLink(generateLink(appLink, VALIDATE_TYPE_LINK, hash.value()));
        var rejectLink = new RejectLink(generateLink(appLink, REJECT_TYPE_LINK, hash.value()));
        return new PairLinks(validateLink, rejectLink);
    }

    private String generateLink(String appLink, String typeLink, String hash) {
        return MessageFormat.format("{0}/api/offers/{1}?hash={2}", appLink, typeLink, hash);
    }
}
