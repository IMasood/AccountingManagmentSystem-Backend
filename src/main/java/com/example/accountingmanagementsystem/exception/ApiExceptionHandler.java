package com.example.accountingmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Object> handleException(ApiException exception){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                exception.getMessage(),
                badRequest,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiExceptionResponse, badRequest);
    }
}
