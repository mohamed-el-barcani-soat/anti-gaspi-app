package com.soat.anti_gaspi.domain;

class Email {
    private final String value;

    private Email(final String email) {
        this.value = email;
    }

    public String getValue() {
        return value;
    }

    public static CreateEmailBuilder create() {
        return new CreateEmailBuilder();
    }

    private static class CreateEmailBuilder {
        private String value;

        private CreateEmailBuilder() {
        }

        public CreateEmailBuilder value(final String value) {
            this.value = value;
            return this;
        }

        public Email build() {
            return new Email(value);
        }
    }
}
