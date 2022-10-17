package com.soat.anti_gaspi.domain;

import java.util.Arrays;

public enum Status {
    ACCEPTED("accepted"),
    REJECTED("rejected"),
    PENDING("pending");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Status from(String value) {
        return Arrays.stream(Status.values())
                .filter(status -> status.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
