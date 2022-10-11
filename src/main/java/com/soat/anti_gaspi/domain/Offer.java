package com.soat.anti_gaspi.domain;

import java.time.OffsetDateTime;


public class Offer implements DomainEntity {
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

    public void create() {

    }

    public static class OfferBuilder {
        private Company company;

        private OfferId id;
        private String title;
        private String description;
        private User user;
        private Status status;
        private Address address;
        private OffsetDateTime availabilityDate;
        private OffsetDateTime expirationDate;

        OfferBuilder() {
        }


        public OfferBuilder id(OfferId id) {
            this.id = id;
            return this;
        }


        public OfferBuilder status(Status status) {
            this.status = status;
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

        public OfferBuilder user(User user) {
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
            return new Offer(id, title, description, user, address, availabilityDate, expirationDate, status);
        }
    }
}
