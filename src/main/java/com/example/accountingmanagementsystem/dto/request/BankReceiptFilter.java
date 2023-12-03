package com.example.accountingmanagementsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BankReceiptFilter {
    private String voucherNo;
    private String flatNo;
    private BigDecimal amount;
    private String date;
}
