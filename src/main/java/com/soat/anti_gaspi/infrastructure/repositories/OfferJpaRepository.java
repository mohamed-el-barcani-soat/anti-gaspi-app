package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.model.OfferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferJpaRepository extends JpaRepository<OfferEntity, String> {
    OfferEntity save(OfferEntity offerEntity);
    Page<OfferEntity> findAll(Pageable pageable);
    Page<OfferEntity> findByStatus(String status);
    Optional<OfferEntity> findByNaturalId(String naturalId);
}
