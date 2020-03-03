package com.example.bigbank.controller.error;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    protected ResponseEntity<Object> handleGameOver(HttpClientErrorException ex) {
        System.out.println(ex.getStatusCode());
        ApiError apiError = new ApiError(ex.getStatusCode(), ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
