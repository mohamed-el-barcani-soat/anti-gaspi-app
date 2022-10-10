package com.soat.anti_gaspi.domain;



class User {

    private final String email;

    private User(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public static CreateEmailBuilder create() {
        return new CreateEmailBuilder();
    }

    public static class CreateEmailBuilder {
        private String value;

        private CreateEmailBuilder() {
        }

        public CreateEmailBuilder email(final String value) {
            this.value = value;
            return this;
        }

        public User build() {
            return new User(value);
        }
    }
}
