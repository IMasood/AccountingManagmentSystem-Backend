package com.example.accountingmanagementsystem.services.impl;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddAccountRequest;
import com.example.accountingmanagementsystem.dto.request.DeleteAccountRequest;
import com.example.accountingmanagementsystem.dto.request.GetAccountDirectoryRequest;
import com.example.accountingmanagementsystem.dto.request.UpdateAccountRequest;
import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import com.example.accountingmanagementsystem.repos.ChartOfAccountRepository;
import com.example.accountingmanagementsystem.services.ChartOfAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChartOfAccountServiceImp implements ChartOfAccountService {

    @Autowired
    private ChartOfAccountRepository chartOfAccountRepository;

    @Override
    public ApiResponse<Long> addAccount(AddAccountRequest request) throws Exception {
        if (chartOfAccountRepository.existsByAccountCode(request.getCreditCode())){
            throw new Exception("Account is already with same credit code!");
        }

        ChartOfAccount account = new ChartOfAccount();
        account.setMasterAccount(request.getMasterAccountCode());
        account.setCreditCode(request.getCreditCode());
        account.setCreditHead(request.getCreditHead());
        chartOfAccountRepository.save(account);
        return new ApiResponse<>(true, "Account is successfully added");
    }

    @Override
    public ApiResponse<Long> updateAccount(long accountId, UpdateAccountRequest request) throws Exception {
        ChartOfAccount account = chartOfAccountRepository.findById(accountId).orElseThrow(
                () -> new RuntimeException("Account not found!")
        );
        account.setMasterAccount(request.getMasterAccountCode());
        account.setCreditCode(request.getCreditCode());
        account.setCreditHead(request.getCreditHead());
        chartOfAccountRepository.save(account);
        return new ApiResponse<>(true, "Account is successfully updated!");
    }

    @Override
    public ApiResponse<Long> deleteAccount(DeleteAccountRequest request) {
        request.getAccountIds().forEach(id-> chartOfAccountRepository.deleteById(id));
        return new ApiResponse<>(true, "Account is successfully deleted!");
    }

    @Override
    public ApiResponse<Page<ChartOfAccount>> getAccountDirectory(GetAccountDirectoryRequest request) {
        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize());
        Page<ChartOfAccount> response = chartOfAccountRepository.findAll(pageRequest);
        return new ApiResponse<>(response);
    }

    @Override
    public ApiResponse<ChartOfAccount> getAccountDetail(Long accountId) {
        ChartOfAccount account = chartOfAccountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found!"));
        return new ApiResponse<>(account);
    }
}
