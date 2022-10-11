package com.soat.anti_gaspi.model;

import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OfferEntity {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column
    private String companyName;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String email;

    @Column
    private String numberAddress;

    @Column
    private String streetAddress;

    @Column
    private String cityAddress;

    @Column
    private String zipCodeAddress;

    @Column
    private String country;

    @Column
    private LocalDate availabilityDate;

    @Column
    private LocalDate expirationDate;

    @Column
    private Status status;

    public static  class OfferEntityBuilder {
         private UUID id;
         private String companyName;

         public OfferEntityBuilder() {}
    }
}
