package com.example.accountingmanagementsystem.services;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddSubAccountRequestDTO;
import com.example.accountingmanagementsystem.dto.request.UpdateSubAccountRequest;

public interface ChartOfAccountService {

    ApiResponse<Long> addAccount(AddSubAccountRequestDTO request) throws Exception;

    ApiResponse<Long> updateAccount(long accountId, UpdateSubAccountRequest request) throws Exception;

    ApiResponse<Long> deleteAccount(long accountId);
}
