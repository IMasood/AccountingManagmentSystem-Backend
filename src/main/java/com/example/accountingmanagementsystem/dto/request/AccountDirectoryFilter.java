package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

@Data
public class AccountDirectoryFilter {
    private Long masterAccount;
    private Long creditCode;
}
