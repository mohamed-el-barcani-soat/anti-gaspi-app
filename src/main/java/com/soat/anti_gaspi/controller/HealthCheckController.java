package com.soat.anti_gaspi.controller;

import com.soat.anti_gaspi.model.Offer;
import com.soat.anti_gaspi.model.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/health")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<String> getPublishedOffers() {
        return ResponseEntity.of(Optional.of("I'm alive"));
    }
}
