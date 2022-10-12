package com.soat.anti_gaspi.domain;

import java.time.OffsetDateTime;

public class OfferAggregate {

    private static OfferId createId(OffsetDateTime availabilityDate, Email email, String title) {
        // TODO String joiner
        var offerId = availabilityDate.toString().concat(email.getValue()).concat(title);

        return new OfferId(offerId);
    }


    public static OfferAggregateBuilder builder() {
        return new OfferAggregateBuilder();
    }

    public static class OfferAggregateBuilder {
        private User user;
        private String title;
        private String description;
        private Address address;
        private OffsetDateTime availabilityDate;
        private OffsetDateTime expirationDate;
        private Status status;

        OfferAggregateBuilder() {

        }

        public OfferAggregateBuilder user(final User user) {
            this.user = user;
            return this;
        }

        public OfferAggregateBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public OfferAggregateBuilder description(final String description) {
            this.description = description;
            return this;
        }

        public OfferAggregateBuilder address(final Address address) {
            this.address = address;
            return this;
        }

        public OfferAggregateBuilder availabilityDate(final OffsetDateTime availabilityDate) {
            this.availabilityDate = availabilityDate;
            return this;
        }

        public OfferAggregateBuilder expirationDate(final OffsetDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public OfferAggregateBuilder status(final Status status) {
            this.status = status;
            return this;
        }

        public Offer build() {
            return Offer.builder()
                    .offerId(createId(availabilityDate, user.getEmail(), title))
                    .user(user)
                    .title(title)
                    .description(description)
                    .address(address)
                    .availabilityDate(availabilityDate)
                    .expirationDate(expirationDate)
                    .status(status)
                    .build();
        }
    }
}
