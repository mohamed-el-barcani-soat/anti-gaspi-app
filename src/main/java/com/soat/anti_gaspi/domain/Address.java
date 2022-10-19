package com.soat.anti_gaspi.domain;

public class Address {
    private final NumberIndicator numberIndicator;
    private final String street;
    private final String city;
    private final String zipcode;
    private final String country;

    public Address(NumberIndicator numberIndicator, String street, String city, String zipcode, String country) {
        this.numberIndicator = numberIndicator;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public String getNumber() {
        return numberIndicator.getNumber();
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipcode;
    }

    public String getCountry() {
        return country;
    }

    public static class AddressBuilder {
        private  NumberIndicator numberIndicator;
        private  String street;
        private  String city;
        private  String zipcode;
        private  String country;

        private AddressBuilder() {
        }

        public AddressBuilder number(final NumberIndicator numberIndicator) {
            this.numberIndicator = numberIndicator;
            return this;
        }

        public AddressBuilder street(final String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder city(final String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder zipcode(final String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public AddressBuilder country(final String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(numberIndicator, street, city, zipcode, country);
        }
    }

}
