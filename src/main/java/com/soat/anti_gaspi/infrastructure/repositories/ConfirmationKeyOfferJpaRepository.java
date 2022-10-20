package com.soat.anti_gaspi.infrastructure.repositories;

import com.soat.anti_gaspi.model.ConfirmationKeyOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationKeyOfferJpaRepository extends JpaRepository<ConfirmationKeyOfferEntity, Long> {
}
