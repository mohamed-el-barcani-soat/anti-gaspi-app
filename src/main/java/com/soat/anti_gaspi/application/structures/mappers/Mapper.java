package com.soat.anti_gaspi.application.structures.mappers;

public abstract class Mapper<From, To, DomainValidator extends Validator<From>> {

    private final DomainValidator validator;

    protected Mapper(final DomainValidator validator) {
        this.validator = validator;
    }

    final public To map(final From source) {
        validator.validate(source);
        return to(source);
    }

    protected abstract To to(final From source);
}
