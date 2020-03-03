package com.example.bigbank.controller.error;

import org.springframework.http.HttpStatus;

public class ApiError {

    private String message;
    private HttpStatus status;

    ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
