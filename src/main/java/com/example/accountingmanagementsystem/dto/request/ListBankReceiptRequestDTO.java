package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

@Data
public class ListBankReceiptRequestDTO {
    private Integer pageNumber;
    private Integer pageSize;
    private BankReceiptFilter filters;
}
