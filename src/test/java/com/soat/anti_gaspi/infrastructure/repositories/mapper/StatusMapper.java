package com.soat.anti_gaspi.infrastructure.repositories.mapper;

import com.soat.anti_gaspi.domain.Status;

public class StatusMapper {
    public static Status map(final String source) {
        return Status.from(source);

    }
}
