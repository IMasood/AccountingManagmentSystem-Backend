package com.example.accountingmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tenantNo;
    private String name;

    @OneToOne
    @JoinColumn(name = "bank_receipt_id")
    private BankReceipt bankReceipt;
}
