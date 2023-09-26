package com.example.accountingmanagementsystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;
    private List<ApiError> errors;

    public ApiResponse(boolean success, String message){
        this.message = message;
        this.success = success;
    }

    public ApiResponse(T data){
        this.data = data;
        this.success = true;
    }

    public ApiResponse(List<ApiError> errors){
        this.success = false;
        this.errors = errors;
    }
}
