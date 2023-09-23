package com.example.accountingmanagementsystem.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BankReceipt {
    private Long id;
    private String voucherNo;

    private String buildingCode;
    private String buildingName;
    private String flatNo;
    private String additionalInfo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


}
