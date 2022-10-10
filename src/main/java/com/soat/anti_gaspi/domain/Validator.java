package com.soat.anti_gaspi.domain;

public interface Validator<Validated> {
    void validate(Validated validated);
}