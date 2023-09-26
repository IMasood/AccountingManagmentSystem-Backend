package com.example.accountingmanagementsystem.entities;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
public class CreditDetails extends BaseEntity {
    private String creditCode;
    private String creditHead;
    private BigDecimal amount;

}
