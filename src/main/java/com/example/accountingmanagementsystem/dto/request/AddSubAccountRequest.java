package com.example.accountingmanagementsystem.dto.request;

import com.example.accountingmanagementsystem.enums.MasterAccounts;
import lombok.Data;

@Data
public class AddSubAccountRequest {
    private MasterAccounts parentAccountType;
    private long accountCode;
    private String name;
    private String description;
}
