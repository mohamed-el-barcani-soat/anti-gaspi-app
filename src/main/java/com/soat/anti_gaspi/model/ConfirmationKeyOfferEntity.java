package com.soat.anti_gaspi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ConfirmationKeyOfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private String offerId;

    @Column
    private String key;

    @Column
    private LocalDateTime creationDate;

}
