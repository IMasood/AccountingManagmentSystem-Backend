package com.example.accountingmanagementsystem.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class ContractDetail extends BaseEntity{

    private String periodOfContract;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private LocalDateTime fasDate;
    private BigDecimal parkingCharges1;
    private BigDecimal parkingCharges2;

    @OneToOne
    @JoinColumn(name = "bank_receipt_id")
    private BankReceipt bankReceipt;
}
