package com.example.accountingmanagementsystem.entities;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class ContractDetail extends BaseEntity {
    private String periodOfContract;
    private LocalDateTime from;
    private LocalDateTime to;
    private LocalDateTime fasDate;
    private BigDecimal parkingCharges1;
    private BigDecimal parkingCharges2;
}
