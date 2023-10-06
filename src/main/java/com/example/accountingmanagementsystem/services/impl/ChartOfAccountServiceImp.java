package com.example.accountingmanagementsystem.services.impl;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddSubAccountRequest;
import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import com.example.accountingmanagementsystem.repos.ChartOfAccountRepository;
import com.example.accountingmanagementsystem.services.ChartOfAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartOfAccountServiceImp implements ChartOfAccountService {

    @Autowired
    private ChartOfAccountRepository chartOfAccountRepository;

    @Override
    public ApiResponse<Long> addSubAccount(AddSubAccountRequest request) {
        ChartOfAccount account = new ChartOfAccount();
        account.setParentAccount(request.getParentAccountType());
        account.setName(request.getName());
        account.setDescription(request.getDescription());
        account.setAccountCode(request.getAccountCode());
        chartOfAccountRepository.save(account);
        return new ApiResponse<>(true, "Account is successfully added");
    }
}
