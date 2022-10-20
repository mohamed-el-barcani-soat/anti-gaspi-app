package com.soat.anti_gaspi.infrastructure.email;

import com.soat.anti_gaspi.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.text.MessageFormat;

@Component
public class LinksServiceImpl implements LinksService {
    private static final String VALIDATE_TYPE_LINK = "validate";
    private static final String REJECT_TYPE_LINK = "reject";
    @Override
    public PairLinks generateLinkBy(Offer offer) {
        String appLink = ServletUriComponentsBuilder.fromCurrentContextPath()
                .build()
                .toUriString();
//        var validateLink = new ValidateLink(generateLink(appLink, VALIDATE_TYPE_LINK, offer.value()));
//        var rejectLink = new RejectLink(generateLink(appLink, REJECT_TYPE_LINK, offer.value()));
//        return new PairLinks(validateLink, rejectLink);
        return null;
    }

    private String generateLink(String appLink, String typeLink, String hash) {
        return MessageFormat.format("{0}/api/offers/{1}?hash={2}", appLink, typeLink, hash);
    }
}
