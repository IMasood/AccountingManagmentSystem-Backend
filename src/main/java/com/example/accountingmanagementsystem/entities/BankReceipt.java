package com.example.accountingmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class BankReceipt extends BaseEntity {
    private String voucherNo;
    private String buildingCode;
    private String buildingName;
    private String flatNo;

    @OneToOne(mappedBy = "bankReceipt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Tenant tenant;

    @OneToOne(mappedBy = "bankReceipt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ContractDetail contract;

    private String additionalInfo;
}
