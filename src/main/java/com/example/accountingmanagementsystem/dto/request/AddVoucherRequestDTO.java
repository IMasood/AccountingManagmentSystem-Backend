package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddVoucherRequestDTO {
    private Long accountCode;
    private String accountHead;
    private String narration;
    private BigDecimal debit;
    private BigDecimal credit;
}
