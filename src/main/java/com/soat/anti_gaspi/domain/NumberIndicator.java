package com.soat.anti_gaspi.domain;

public class NumberIndicator {
    private final int number;
    private final String indicator;


    public NumberIndicator(int number, String indicator) {
        this.number = number;
        this.indicator = indicator;
    }

    public static NumberIndicatorBuilder builder() {
        return new NumberIndicatorBuilder();
    }

    static class NumberIndicatorBuilder {
        private int number;
        private String indicator;

        NumberIndicatorBuilder() {

        }

        NumberIndicatorBuilder number(final int number) {
            this.number = number;
            return this;
        }

        NumberIndicatorBuilder indicator(final String indicator) {
            this.indicator = indicator;
            return this;
        }

        NumberIndicator build() {
            return new NumberIndicator(number, indicator);
        }
    }
}
