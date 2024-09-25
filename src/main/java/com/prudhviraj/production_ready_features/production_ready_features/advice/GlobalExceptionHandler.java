package com.prudhviraj.production_ready_features.production_ready_features.advice;

import com.prudhviraj.production_ready_features.production_ready_features.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> resourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request) {

        ApiError error = new ApiError();
        error.setTimestamp(LocalDateTime.now()); // Set the current timestamp
        error.setPath(request.getRequestURI()); // Get the request URI
        error.setStatus(HttpStatus.NOT_FOUND.value()); // Set the HTTP status code
        error.setError(exception.getMessage()); // Set the error message
        error.setRequestId(UUID.randomUUID().toString()); // Generate or set a unique request ID here

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
