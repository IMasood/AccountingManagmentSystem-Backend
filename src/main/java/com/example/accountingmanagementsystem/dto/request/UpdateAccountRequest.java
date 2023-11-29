package com.example.accountingmanagementsystem.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateAccountRequest {
    private String id;
    private Long masterAccountCode;
    private Long creditCode;
    @NotEmpty
    private String creditHead;
}
