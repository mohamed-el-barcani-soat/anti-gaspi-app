package com.soat.anti_gaspi.infrastructure.repositories;

import java.util.UUID;

import com.soat.anti_gaspi.model.Offer;
import com.soat.anti_gaspi.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferJpaRepository extends PagingAndSortingRepository<Offer, UUID> {

    Page<Offer> findAll(Pageable pageable);
    Page<Offer> findAllByStatus(Status status, Pageable pageable);
}
