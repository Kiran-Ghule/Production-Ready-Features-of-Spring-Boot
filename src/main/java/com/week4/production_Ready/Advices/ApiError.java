package com.week4.production_Ready.Advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private LocalDateTime timestamp;
    private String message;
    private HttpStatus status;

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(String message, HttpStatus status) {
        this();
        this.status = status;
        this.message = message;
    }
}
