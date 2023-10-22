package com.example.accountingmanagementsystem.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ChartOfAccount extends BaseEntity{
    private Long masterAccount;
    private Long creditCode;
    private String creditHead;
}
