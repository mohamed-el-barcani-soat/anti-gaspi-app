package com.soat.anti_gaspi.domain;

import java.time.OffsetDateTime;

import static com.soat.anti_gaspi.domain.Status.PENDING;


public class Offer {
    private final OfferId offerId;
    private final String title;
    private final String description;
    private final User user;
    private final Address address;
    private final Status status;
    private final OffsetDateTime availabilityDate;
    private final OffsetDateTime expirationDate;

    private Offer(OfferId offerId, String title, String description, User user, Address address, OffsetDateTime availabilityDate, OffsetDateTime expirationDate, Status status) {
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.user = user;
        this.address = address;
        this.availabilityDate = availabilityDate;
        this.expirationDate = expirationDate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getEmail() {
        return user;
    }

    public Address getAddress() {
        return address;
    }

    public OffsetDateTime getAvailabilityDate() {
        return availabilityDate;
    }

    public OffsetDateTime getExpirationDate() {
        return expirationDate;
    }

    public Status getStatus() {
        return status;
    }

    public OfferId getOfferId() {
        return offerId;
    }


    public static OfferBuilder builder() {
        return new OfferBuilder();
    }

    public static class OfferBuilder {
        private Company company;
        private String title;
        private String description;
        private User user;
        private Address address;
        private OffsetDateTime availabilityDate;
        private OffsetDateTime expirationDate;

        OfferBuilder() {
        }

        public OfferBuilder companyName(Company company) {
            this.company = company;
            return this;
        }

        public OfferBuilder title(String title) {
            this.title = title;
            return this;
        }

        public OfferBuilder description(String description) {
            this.description = description;
            return this;
        }

        public OfferBuilder email(User user) {
            this.user = user;
            return this;
        }

        public OfferBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public OfferBuilder availabilityDate(OffsetDateTime availabilityDate) {
            this.availabilityDate = availabilityDate;
            return this;
        }

        public OfferBuilder expirationDate(OffsetDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Offer build() {
            // Toutes les constructions intelligentes vont se faire sur un aggrégat qui englobera l'offre (notamment l'ID)
            var id = new OfferId("id");
            return new Offer(id, title, description, user, address, availabilityDate, expirationDate, PENDING);
        }
    }
}
