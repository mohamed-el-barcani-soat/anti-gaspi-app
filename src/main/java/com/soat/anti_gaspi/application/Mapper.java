package com.soat.anti_gaspi.application;

import com.soat.anti_gaspi.domain.Validator;

public abstract class Mapper<From, To extends DomainEntity, DomainValidator extends Validator<From>> {

    private final DomainValidator validator;

    protected Mapper(final DomainValidator validator) {
        this.validator = validator;
    }

    final public To map(final From source) {
        validator.validate(source);
        return to(source);
    }

    abstract To to(final From source);
}
