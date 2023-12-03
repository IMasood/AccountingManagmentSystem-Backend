package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

@Data
public class ListVoucherFilter {
    private Long accountCode;
    private String accountHead;
}
