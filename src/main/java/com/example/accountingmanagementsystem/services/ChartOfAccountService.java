package com.example.accountingmanagementsystem.services;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddAccountRequest;
import com.example.accountingmanagementsystem.dto.request.DeleteAccountRequest;
import com.example.accountingmanagementsystem.dto.request.GetAccountDirectoryRequest;
import com.example.accountingmanagementsystem.dto.request.UpdateAccountRequest;
import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import org.springframework.data.domain.Page;

public interface ChartOfAccountService {

    ApiResponse<Long> addAccount(AddAccountRequest request) throws Exception;

    ApiResponse<Long> updateAccount(long accountId, UpdateAccountRequest request) throws Exception;

    ApiResponse<Long> deleteAccount(DeleteAccountRequest accountId);

    ApiResponse<Page<ChartOfAccount>> getAccountDirectory(GetAccountDirectoryRequest request);

    ApiResponse<ChartOfAccount> getAccountDetail(Long accountId);
}
