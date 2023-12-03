package com.example.accountingmanagementsystem.repos;

import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import com.example.accountingmanagementsystem.entities.JournalVoucher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalVoucherRepository extends MongoRepository<JournalVoucher, String> {
}
