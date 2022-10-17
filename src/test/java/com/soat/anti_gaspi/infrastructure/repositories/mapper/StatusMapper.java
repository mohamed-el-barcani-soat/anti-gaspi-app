package com.soat.anti_gaspi.infrastructure.repositories.mapper;

import com.soat.anti_gaspi.domain.Status;

import java.util.Optional;

public class StatusMapper {
    public static Optional<Status> map(final String source) {
        try {
            return Optional.of(Enum.valueOf(Status.class, source));
        } catch (Exception exp) {
            return Optional.empty();
        }
    }
}
