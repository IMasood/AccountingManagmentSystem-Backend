package com.example.accountingmanagementsystem.services;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddAccountRequest;
import com.example.accountingmanagementsystem.dto.request.DeleteAccountRequest;
import com.example.accountingmanagementsystem.dto.request.GetAccountDirectoryRequest;
import com.example.accountingmanagementsystem.dto.request.UpdateAccountRequest;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.dto.response.GetCreditCodesResponse;
import com.example.accountingmanagementsystem.entities.ChartOfAccount;

import java.util.List;

public interface ChartOfAccountService {

    ApiResponse<String> addAccount(AddAccountRequest request) throws Exception;

    ApiResponse<Void> updateAccount(UpdateAccountRequest request) throws Exception;

    ApiResponse<Void> deleteAccount(DeleteAccountRequest accountId);

    ApiResponse<CustomPageResponse<ChartOfAccount>> getAccountDirectory(GetAccountDirectoryRequest request);

    ApiResponse<ChartOfAccount> getAccountDetail(String accountId);

    ApiResponse<List<GetCreditCodesResponse>> getAllCreditCodes();
}
