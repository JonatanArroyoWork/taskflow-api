package com.jam.taskflow.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.time.Instant;

import com.jam.taskflow.api.dto.HealthResponse;

@RestController
public class HealthController {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${app.env:dev}")
    private String env;

    @GetMapping("/health")
    public HealthResponse health() {
        return new HealthResponse("UP",
        appName,
        env,
        Instant.now());
    }
}