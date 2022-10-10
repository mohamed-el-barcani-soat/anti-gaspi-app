package com.soat.anti_gaspi.domain;



class User {

    private final Email email;
    private final Company company;

    private User(final Email email, Company company) {
        this.email = email;
        this.company = company;
    }

    public Email getEmail() {
        return email;
    }

    public Company getCompany() {
        return company;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private Email email;
        private Company company;

        private UserBuilder() {
        }

        public UserBuilder email(final Email email) {
            this.email = email;
            return this;
        }

        public UserBuilder company(final Company company) {
            this.company = company;
            return this;
        }

        public User build() {
            return new User(email, company);
        }
    }
}
