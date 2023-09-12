package com.products.similar.infrastructure.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        log.error("Product not found exception occurred: {}", ex.getMessage(), ex);  // Logging the exception with its message
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<String> handleExternalServiceException(ExternalServiceException ex) {
        log.error("External service exception occurred: {}", ex.getMessage(), ex);  // Logging the exception with its message
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(feign.RetryableException.class)
    public ResponseEntity<String> handleFeignRetryableException(feign.RetryableException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof java.net.SocketTimeoutException) {
            log.warn("Feign retryable exception due to socket timeout: {}", ex.getMessage(), ex);  // Logging the timeout exception
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Request timeout.");
        }
        log.error("Feign retryable exception occurred: {}", ex.getMessage(), ex);  // Logging other retryable exceptions
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error communicating with external service.");
    }

}
