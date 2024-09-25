package com.prudhviraj.production_ready_features.production_ready_features.advice;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {
    private LocalDateTime timestamp;
    private String path;
    private int status;
    private String error;
    private String requestId;

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(String path, int status, String error, String requestId) {
        this();
        this.path = path;
        this.status = status;
        this.error = error;
        this.requestId = requestId;
    }

    // Optional: Add a constructor that takes HttpStatus
    public ApiError(String path, HttpStatus httpStatus, String error, String requestId) {
        this(path, httpStatus.value(), error, requestId);
    }
}
