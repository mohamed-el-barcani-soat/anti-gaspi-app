package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.domain.Offer;
import com.soat.anti_gaspi.domain.OfferId;
import com.soat.anti_gaspi.domain.OfferRepository;
import com.soat.anti_gaspi.infrastructure.mappers.OfferMapper;
import com.soat.anti_gaspi.model.OfferEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Component
@AllArgsConstructor
public class OfferAdapter implements OfferRepository {

    private final OfferJpaRepository offerRepository;
    private final OfferMapper offerMapper;

    @Override
    @Transactional
    public OfferId create(final Offer offer) {
        var offerEntity = offerRepository.save(offerMapper.toEntity(offer));
        return offerMapper.toOffer(offerEntity).getOfferId();
    }

    @Override
    @Transactional
    public Optional<Offer> update(final Offer offer) {
        return offerRepository.findByNaturalId(offer.getOfferId().value())
                .map((entity -> {
                    var savedEntity = offerRepository.save(mergeEntity(offer, entity));
                    return offerMapper.toOffer(savedEntity);
                }));
    }

    @Override
    @Transactional
    public void delete(final Offer offer) {
        offerRepository
                .findByNaturalId(offer.getOfferId().value())
                .ifPresent(offerRepository::delete);
    }

    @Override
    public Optional<Offer> find(OfferId offerId) {
        return offerRepository.findByNaturalId(offerId.value()).map(offerMapper::toOffer);
    }

    private OfferEntity mergeEntity(final Offer offer, final OfferEntity entity) {
        return OfferEntity.builder()
                .id(entity.getId())
                .naturalId(offer.getOfferId().value())
                .availabilityDate(offer.getAvailabilityDate().toLocalDateTime())
                .country(offer.getAddress().getCountry())
                .email(offer.getUser().getEmail().getValue())
                .description(offer.getDescription())
                .expirationDate(offer.getExpirationDate().toLocalDateTime())
                .title(offer.getTitle())
                .number(offer.getAddress().getNumber())
                .status(offer.getStatus().getValue())
                .city(offer.getAddress().getCity())
                .street(offer.getAddress().getStreet())
                .zipCode(offer.getAddress().getZipCode())
                .build();
    }
}
