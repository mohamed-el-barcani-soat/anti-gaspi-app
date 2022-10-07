package com.soat.anti_gaspi.domain.offer;

class CompanyName {

    private final String value;

    private CompanyName(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CreateCompanyBuilder create() {
        return new CreateCompanyBuilder();
    }

    public static class CreateCompanyBuilder {
        private String value;

        public CreateCompanyBuilder() {
        }

        public CreateCompanyBuilder value(final String value) {
            this.value = value;
            return this;
        }

        public CompanyName build() {
            return new CompanyName(value);
        }
    }
}
