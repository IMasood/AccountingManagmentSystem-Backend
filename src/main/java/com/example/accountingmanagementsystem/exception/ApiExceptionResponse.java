package com.example.accountingmanagementsystem.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
public class ApiExceptionResponse {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;

    public ApiExceptionResponse(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
