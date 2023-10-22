package com.example.accountingmanagementsystem.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateAccountRequest {
    @NotEmpty
    private Long masterAccountCode;
    @NotEmpty
    private Long creditCode;
    @NotEmpty
    private String creditHead;
}
