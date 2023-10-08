package com.example.accountingmanagementsystem.dto.request;

import com.example.accountingmanagementsystem.enums.MasterAccounts;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddSubAccountRequestDTO {

    @NotNull
    private MasterAccounts parentAccountType;

    private long accountCode;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;
}
