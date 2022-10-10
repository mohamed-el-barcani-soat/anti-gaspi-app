package com.soat.anti_gaspi.domain;


public class User {

    private final String username;
    private final Email email;


    private User(final Email email, Company company, String username) {
        this.email = email;
        this.username = username;
    }

    public Email getEmail() {
        return email;
    }


    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private Email email;
        private Company company;
        private String username;

        private UserBuilder() {
        }

        public UserBuilder email(final Email email) {
            this.email = email;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public User build() {
            return new User(email, company, username);
        }

    }
}
