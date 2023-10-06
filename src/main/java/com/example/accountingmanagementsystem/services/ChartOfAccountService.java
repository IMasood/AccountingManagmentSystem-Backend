package com.example.accountingmanagementsystem.services;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddSubAccountRequest;
import com.example.accountingmanagementsystem.dto.request.UpdateSubAccountRequest;

public interface ChartOfAccountService {

    ApiResponse<Long> addAccount(AddSubAccountRequest request) throws Exception;

    ApiResponse<Long> updateAccount(long accountId, UpdateSubAccountRequest request) throws Exception;

    ApiResponse<Long> deleteAccount(long accountId);
}
