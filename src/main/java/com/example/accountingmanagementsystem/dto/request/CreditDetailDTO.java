package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditDetailDTO {
    private String creditCode;
    private String creditHead;
    private BigDecimal amount;
}
