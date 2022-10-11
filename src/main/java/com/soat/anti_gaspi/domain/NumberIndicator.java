package com.soat.anti_gaspi.domain;

public class NumberIndicator {
    private final String number;

    public NumberIndicator(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }


    public static NumberIndicatorBuilder builder() {
        return new NumberIndicatorBuilder();
    }

    public static class NumberIndicatorBuilder {
        private String number;
        public NumberIndicatorBuilder() {

        }

        public NumberIndicatorBuilder number(final String number) {
            this.number = number;
            return this;
        }


        public NumberIndicator build() {
            return new NumberIndicator(number);
        }
    }
}
