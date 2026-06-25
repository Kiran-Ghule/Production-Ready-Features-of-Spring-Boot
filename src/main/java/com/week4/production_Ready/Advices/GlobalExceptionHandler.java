package com.week4.production_Ready.Advices;

import com.week4.production_Ready.Exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value= ResourceNotFound.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFound e) {
          return new ResponseEntity<>( new ApiError(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);

    }
}
