package com.soat.anti_gaspi.domain;

class Company {

    private final String name;

    private Company(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CompanyBuilder builder() {
        return new CompanyBuilder();
    }

    public static class CompanyBuilder {
        private String name;

        public CompanyBuilder() {
        }

        public CompanyBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public Company build() {
            return new Company(name);
        }
    }
}
