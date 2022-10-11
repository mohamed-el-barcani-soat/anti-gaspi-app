package com.soat.anti_gaspi.model;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.*;

@Entity
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NaturalId
    private String naturalId;
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

    private OfferEntity(String id, String naturalId, String title, String description, String email, String numberAddress, String streetAddress, String cityAddress, String zipCodeAddress, String country, LocalDate availabilityDate, LocalDate expirationDate, Status status) {
        this.id = id;
        this.naturalId = naturalId;
        this.title = title;
        this.description = description;
        this.email = email;
        this.numberAddress = numberAddress;
        this.streetAddress = streetAddress;
        this.cityAddress = cityAddress;
        this.zipCodeAddress = zipCodeAddress;
        this.country = country;
        this.availabilityDate = availabilityDate;
        this.expirationDate = expirationDate;
        this.status = status;
    }


    public static class OfferEntityBuilder {
        private String id;
        private String naturalId;
        private String title;
        private String description;
        private String email;
        private String numberAddress;
        private String streetAddress;
        private String cityAddress;
        private String zipCodeAddress;
        private String country;
        private LocalDate availabilityDate;
        private LocalDate expirationDate;
        private Status status;

        public static OfferEntityBuilder builder() {
            return new OfferEntityBuilder();
        }

        public OfferEntityBuilder id(String id) {
            this.id = id;
            return this;
        }

        public OfferEntityBuilder naturalId(String naturalId) {
            this.naturalId = naturalId;
            return this;
        }

        public OfferEntityBuilder title(String title) {
            this.title = title;
            return this;
        }

        public OfferEntityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public OfferEntityBuilder email(String email) {
            this.email = email;
            return this;
        }

        public OfferEntityBuilder numberAddress(String numberAddress) {
            this.numberAddress = numberAddress;
            return this;
        }

        public OfferEntityBuilder streetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public OfferEntityBuilder cityAddress(String cityAddress) {
            this.cityAddress = cityAddress;
            return this;
        }

        public OfferEntityBuilder zipCodeAddress(String zipCodeAddress) {
            this.zipCodeAddress = zipCodeAddress;
            return this;
        }

        public OfferEntityBuilder country(String country) {
            this.country = country;
            return this;
        }

        public OfferEntityBuilder availabilityDate(LocalDate availabilityDate) {
            this.availabilityDate = availabilityDate;
            return this;
        }

        public OfferEntityBuilder expirationDate(LocalDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public OfferEntityBuilder status(Status status) {
            this.status = status;
            return this;
        }

        public OfferEntity build() {
            return new OfferEntity(id, naturalId, title, description, email, numberAddress, streetAddress, cityAddress, zipCodeAddress, country, availabilityDate, expirationDate, status);
        }
    }
}
