package com.example.accountingmanagementsystem.entities;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class ChequeDetail extends BaseEntity{
    private LocalDateTime chequeDate;
    private String chequeDetail;
    private String drAccount;
    private String bankName;
    private String depositBank;
    private String drawnBank;
    private String chequeNumber;
    private BigDecimal amount;
}
