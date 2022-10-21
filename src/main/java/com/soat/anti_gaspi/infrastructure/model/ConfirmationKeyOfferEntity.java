package com.soat.anti_gaspi.infrastructure.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity()
@Table(name = "key_offer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ConfirmationKeyOfferEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "offer_id")
    private String offerId;

    @Column(name = "key_hash")
    private String hash;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;




}
