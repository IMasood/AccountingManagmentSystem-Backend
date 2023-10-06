package com.example.accountingmanagementsystem.entities;

import com.example.accountingmanagementsystem.enums.MasterAccounts;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
public class ChartOfAccount extends BaseEntity{
    private String name;
    @Enumerated(EnumType.STRING)
    private MasterAccounts parentAccount;
    private String description;
    private long accountCode;
}
