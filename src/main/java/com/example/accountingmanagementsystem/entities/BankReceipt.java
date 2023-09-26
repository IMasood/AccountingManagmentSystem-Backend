package com.example.accountingmanagementsystem.entities;

import jakarta.persistence.Entity;
import lombok.Data;
@Data
@Entity
public class BankReceipt extends BaseEntity {
    private String voucherNo;
    private String buildingCode;
    private String buildingName;
    private String flatNo;
    private String additionalInfo;
}
