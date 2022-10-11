package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.model.OfferEntity;
import com.soat.anti_gaspi.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfferJpaRepository extends JpaRepository<OfferEntity, UUID> {

    Page<OfferEntity> findAll(Pageable pageable);
    Page<OfferEntity> findAllByStatus(Status status, Pageable pageable);

    OfferEntity save(OfferEntity offer);
}
