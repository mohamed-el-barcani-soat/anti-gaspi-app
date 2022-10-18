package com.soat.anti_gaspi.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "offer")//todo table
public class OfferEntity {
    protected OfferEntity() {
    }

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NaturalId()
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

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "country")
    private String country;

    @Column(name = "availability_date")
    private LocalDateTime availabilityDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Enumerated(EnumType.STRING)
    private com.soat.anti_gaspi.domain.Status status;

    public String getId() {
        return id;
    }

    public String getNaturalId() {
        return naturalId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public LocalDateTime getAvailabilityDate() {
        return availabilityDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public com.soat.anti_gaspi.domain.Status getStatus() {
        return status;
    }

    private OfferEntity(String naturalId, String title, String description, String email, String number, String street, String city, String zipCode, String country, LocalDateTime availabilityDate, LocalDateTime expirationDate, com.soat.anti_gaspi.domain.Status status) {
        this.naturalId = naturalId;
        this.title = title;
        this.description = description;
        this.email = email;
        this.number = number;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
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
        private LocalDateTime availabilityDate;
        private LocalDateTime expirationDate;
        private com.soat.anti_gaspi.domain.Status status;

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

        public OfferEntityBuilder availabilityDate(LocalDateTime availabilityDate) {
            this.availabilityDate = availabilityDate;
            return this;
        }

        public OfferEntityBuilder expirationDate(LocalDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public OfferEntityBuilder status(com.soat.anti_gaspi.domain.Status status) {
            this.status = status;
            return this;
        }

        public OfferEntity build() {
            return new OfferEntity(naturalId, title, description, email, numberAddress, streetAddress, cityAddress, zipCodeAddress, country, availabilityDate, expirationDate, status);
        }
    }
}
