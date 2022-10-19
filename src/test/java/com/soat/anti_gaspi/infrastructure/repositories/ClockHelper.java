package com.soat.anti_gaspi.infrastructure.repositories;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class ClockHelper {

    public static Clock getClock() {
        return Clock.fixed(Instant.parse("2022-10-10T00:00:00.00Z"), ZoneId.of("Europe/Berlin"));
    }
}
