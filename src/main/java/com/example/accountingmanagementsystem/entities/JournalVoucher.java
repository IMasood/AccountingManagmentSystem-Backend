package com.example.accountingmanagementsystem.entities;

import com.example.accountingmanagementsystem.dto.request.AddVoucherRequestDTO;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Document
public class JournalVoucher extends BaseEntity{
    private Long accountCode;
    private String accountHead;
    private String narration;
    private BigDecimal debit;
    private BigDecimal credit;

    public JournalVoucher() {
    }

    public JournalVoucher(AddVoucherRequestDTO request) {
        this.accountCode = request.getAccountCode();
        this.accountHead = request.getAccountHead();
        this.narration = request.getNarration();
        this.debit = request.getDebit();
        this.credit = request.getCredit();
    }
}
