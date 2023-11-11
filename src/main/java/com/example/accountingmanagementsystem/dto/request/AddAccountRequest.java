package com.example.accountingmanagementsystem.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AddAccountRequest {
    private Long masterAccountCode;
    private Long creditCode;
    @NotEmpty
    private String creditHead;
}
