package com.soat.anti_gaspi.domain;

public class NumberIndicator {
    private final int number;
    private final String indicator;

    public NumberIndicator(int number, String indicator) {
        this.number = number;
        this.indicator = indicator;
    }

    public int getNumber() {
        return number;
    }

    public String getIndicator() {
        return indicator;
    }

    public static NumberIndicatorBuilder builder() {
        return new NumberIndicatorBuilder();
    }

    public static class NumberIndicatorBuilder {
        private int number;
        private String indicator;

        public NumberIndicatorBuilder() {

        }

        public NumberIndicatorBuilder number(final int number) {
            this.number = number;
            return this;
        }

        public NumberIndicatorBuilder indicator(final String indicator) {
            this.indicator = indicator;
            return this;
        }

        public NumberIndicator build() {
            return new NumberIndicator(number, indicator);
        }
    }
}
