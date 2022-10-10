package com.soat.anti_gaspi.application.structures.mappers;

public interface Validator<Validated> {
    void validate(Validated validated);
}