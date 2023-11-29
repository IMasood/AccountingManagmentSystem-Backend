package com.example.accountingmanagementsystem.entities;

//import jakarta.persistence.Entity;
//import lombok.Data;

//@Entity
//@Data
public class JournalVoucher extends BaseEntity{
    private Long accountCode;
    private String accountHead;
    private String narration;
    private Float debit;
    private Float credit;
}
