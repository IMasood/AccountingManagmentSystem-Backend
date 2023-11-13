package com.example.accountingmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tenantNo;
    private String name;

    private String periodOfContract;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private LocalDateTime fasDate;
    private BigDecimal parkingCharges1;
    private BigDecimal parkingCharges2;
    private String additionalInfo;

    @OneToMany(mappedBy = "tenant")
    private Set<CreditDetails> creditDetails;

}
