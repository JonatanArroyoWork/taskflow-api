package com.jam.taskflow.api.dto;

import java.time.Instant;

public class HealthResponse {
    private String status;
    private String app;
    private String env;
    private Instant timestamp;

    public HealthResponse(String status, String app, String env, Instant timestamp) {
        this.status = status;
        this.app = app;
        this.env = env;
        this.timestamp = timestamp;
    }

    public String getStatus() { return status; }
    public String getApp() { return app; }
    public String getEnv() { return env; }
    public Instant getTimestamp() { return timestamp; }

}