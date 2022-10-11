package com.soat.anti_gaspi.infrastructure.mappers;

public abstract class Mapper<From, To> {

    final public To map(final From source) {
        return to(source);
    }

    protected abstract To to(final From source);
}
