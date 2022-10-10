package com.soat.anti_gaspi.application.exceptions;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RestException {
    private final String message;
    private final int httpStatus;
}
