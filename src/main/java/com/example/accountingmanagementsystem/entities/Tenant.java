package com.example.accountingmanagementsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Tenant extends BaseEntity{
    private String tenantNo;
    private String name;
    @OneToMany
    private List<CreditDetails> creditDetail;

}
