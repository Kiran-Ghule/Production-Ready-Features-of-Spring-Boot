package com.example.demo.Advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseApi<T> {
    private LocalDateTime timestamp;
    private T data;
    private ApiError error;

    public ResponseApi() {
        this.timestamp = LocalDateTime.now();
    }

    public ResponseApi(ApiError error) {
        this();
        this.error = error;
    }

    public ResponseApi(T data) {
        this();
        this.data = data;
    }



}
