package com.example.accountingmanagementsystem.services.impl;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddSubAccountRequest;
import com.example.accountingmanagementsystem.dto.request.UpdateSubAccountRequest;
import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import com.example.accountingmanagementsystem.enums.MasterAccounts;
import com.example.accountingmanagementsystem.repos.ChartOfAccountRepository;
import com.example.accountingmanagementsystem.services.ChartOfAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartOfAccountServiceImp implements ChartOfAccountService {

    @Autowired
    private ChartOfAccountRepository chartOfAccountRepository;

    @Override
    public ApiResponse<Long> addAccount(AddSubAccountRequest request) throws Exception {
        if (chartOfAccountRepository.existsByAccountCode(request.getAccountCode())){
            throw new Exception("Account is already with same account code!");
        }

        ChartOfAccount account = new ChartOfAccount();
        account.setParentAccount(request.getParentAccountType());
        account.setName(request.getName());
        account.setDescription(request.getDescription());
        account.setAccountCode(request.getAccountCode());
        chartOfAccountRepository.save(account);
        return new ApiResponse<>(true, "Account is successfully added");
    }

    @Override
    public ApiResponse<Long> updateAccount(long accountId, UpdateSubAccountRequest request) throws Exception {
        ChartOfAccount account = chartOfAccountRepository.findById(accountId).orElseThrow(
                () -> new RuntimeException("Account not found!")
        );

        account.setName(request.getName());
        account.setAccountCode(request.getAccountCode());
        account.setParentAccount(request.getParentAccountType());
        account.setDescription(request.getDescription());
        chartOfAccountRepository.save(account);
        return new ApiResponse<>(true, "Account is successfully updated!");
    }

    @Override
    public ApiResponse<Long> deleteAccount(long accountId) {
        if (!chartOfAccountRepository.existsById(accountId)) {
            throw new RuntimeException("Account not found!");
        }

        chartOfAccountRepository.deleteById(accountId);
        return new ApiResponse<>(true, "Account is successfully deleted!");
    }
}
