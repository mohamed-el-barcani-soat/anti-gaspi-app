package com.soat.anti_gaspi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/health")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<String> getPublishedOffers() {
        return ResponseEntity.of(Optional.of("I'm alive and MM as well"));
    }
}
