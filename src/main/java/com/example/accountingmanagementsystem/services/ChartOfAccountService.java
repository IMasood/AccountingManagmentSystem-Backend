package com.example.accountingmanagementsystem.services;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddSubAccountRequest;

public interface ChartOfAccountService {

    ApiResponse<Long> addSubAccount(AddSubAccountRequest request);
}
