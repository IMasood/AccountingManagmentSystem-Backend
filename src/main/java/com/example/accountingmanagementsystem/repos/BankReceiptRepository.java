package com.example.accountingmanagementsystem.repos;

import com.example.accountingmanagementsystem.entities.BankReceipt;
import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankReceiptRepository extends MongoRepository<BankReceipt, String> {
}
