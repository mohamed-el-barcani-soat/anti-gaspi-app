package com.soat.anti_gaspi.domain;

public class Email {
    private final String value;

    private Email(final String email) {
        this.value = email;
    }

    public String getValue() {
        return value;
    }

    public static EmailBuilder builder() {
        return new EmailBuilder();
    }

    public static class EmailBuilder {
        private String value;

        private EmailBuilder() {
        }

        public EmailBuilder value(final String value) {
            this.value = value;
            return this;
        }

        public Email build() {
            return new Email(value);
        }
    }
}
