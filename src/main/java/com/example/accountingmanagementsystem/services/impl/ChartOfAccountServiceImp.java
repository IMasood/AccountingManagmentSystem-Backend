package com.example.accountingmanagementsystem.services.impl;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddAccountRequest;
import com.example.accountingmanagementsystem.dto.request.DeleteAccountRequest;
import com.example.accountingmanagementsystem.dto.request.GetAccountDirectoryRequest;
import com.example.accountingmanagementsystem.dto.request.UpdateAccountRequest;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.dto.response.GetCreditCodesResponse;
import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import com.example.accountingmanagementsystem.repos.ChartOfAccountFilterSpecification;
import com.example.accountingmanagementsystem.repos.ChartOfAccountRepository;
import com.example.accountingmanagementsystem.services.ChartOfAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChartOfAccountServiceImp implements ChartOfAccountService {

    @Autowired
    private ChartOfAccountRepository chartOfAccountRepository;

    @Override
    public ApiResponse<String> addAccount(AddAccountRequest request) throws Exception {
        if (chartOfAccountRepository.existsByCreditCode(request.getCreditCode())){
            throw new Exception("Account is already with same credit code!");
        }

        ChartOfAccount account = new ChartOfAccount();
        account.setMasterAccount(request.getMasterAccountCode());
        account.setCreditCode(request.getCreditCode());
        account.setCreditHead(request.getCreditHead());
        account.setCreatedDate(LocalDateTime.now());
        account.setModifiedDate(LocalDateTime.now());
        chartOfAccountRepository.save(account);
        return new ApiResponse<>(true, "Account is successfully added");
    }

    @Override
    public ApiResponse<Void> updateAccount(UpdateAccountRequest request) throws Exception {
        ChartOfAccount account = chartOfAccountRepository.findById(request.getId()).orElseThrow(
                () -> new RuntimeException("Account not found!")
        );
        account.setMasterAccount(request.getMasterAccountCode());
        account.setCreditCode(request.getCreditCode());
        account.setCreditHead(request.getCreditHead());
        chartOfAccountRepository.save(account);
        return new ApiResponse<>(true, "Account is successfully updated!");
    }

    @Override
    public ApiResponse<Void> deleteAccount(DeleteAccountRequest request) {
        request.getAccountIds().forEach(id-> chartOfAccountRepository.deleteById(id));
        return new ApiResponse<>(true, "Account is successfully deleted!");
    }

    @Override
    public ApiResponse<CustomPageResponse<ChartOfAccount>> getAccountDirectory(GetAccountDirectoryRequest request) {
        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize());
        Page<ChartOfAccount> accountDirectory = chartOfAccountRepository.findAll(pageRequest);
        return new ApiResponse<>(new CustomPageResponse<>(accountDirectory));
    }

    @Override
    public ApiResponse<ChartOfAccount> getAccountDetail(Long accountId) {
////        ChartOfAccount account = chartOfAccountRepository.findById(accountId)
////                .orElseThrow(() -> new RuntimeException("Account not found!"));
//        return new ApiResponse<>(account);
        return null;
    }

    @Override
    public ApiResponse<List<GetCreditCodesResponse>> getAllCreditCodes() {
        List<GetCreditCodesResponse> response = chartOfAccountRepository.findAll()
                .stream()
                .map(chartOfAccount -> {
                    GetCreditCodesResponse creditCodesResponse = new GetCreditCodesResponse();
                    //creditCodesResponse.setId(chartOfAccount.getId());
                    creditCodesResponse.setCreditCode(chartOfAccount.getCreditCode());
                    creditCodesResponse.setCreditHead(chartOfAccount.getCreditHead());
                    return creditCodesResponse;
                }).collect(Collectors.toList());
        return new ApiResponse<>(response);
    }


}
