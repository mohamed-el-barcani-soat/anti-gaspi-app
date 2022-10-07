package com.soat.anti_gaspi.domain.offer;

public class Address {
    private final int number;
    private final String street;
    private final String city;
    private final String zipcode;
    private final String country;

    public Address(int number, String street, String city, String zipcode, String country) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }



    public static CreateAddressBuilder create() {
        return new CreateAddressBuilder();
    }

    public static class CreateAddressBuilder {
        private  int number;
        private  String street;
        private  String city;
        private  String zipcode;
        private  String country;

        private CreateAddressBuilder() {
        }

        public CreateAddressBuilder number(final int number) {
            this.number = number;
            return this;
        }

        public CreateAddressBuilder street(final String street) {
            this.street = street;
            return this;
        }

        public CreateAddressBuilder city(final String city) {
            this.city = city;
            return this;
        }

        public CreateAddressBuilder zipcode(final String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public CreateAddressBuilder country(final String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(number, street, city, zipcode, country);
        }
    }

    public int getNumber() {
        return number;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getStreet() {
        return street;
    }

}
