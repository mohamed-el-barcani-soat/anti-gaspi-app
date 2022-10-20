package com.soat.anti_gaspi.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;


// TODO import * bad bad
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity()
@Table(name = "offer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OfferEntity {

    // TODO prefere a long
    @Id
    @GeneratedValue
    private UUID id;

    @NaturalId
    @Column(name = "natural_id")
    private String naturalId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "email")
    private String email;

    @Column(name = "number")
    private String number;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "zipcode")
    private String zipCode;

    @Column(name = "country")
    private String country;

    @Column(name = "availability_date")
    private LocalDateTime availabilityDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    private String status;
}
