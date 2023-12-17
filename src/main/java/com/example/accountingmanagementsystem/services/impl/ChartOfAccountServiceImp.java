package com.example.accountingmanagementsystem.services.impl;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddAccountRequest;
import com.example.accountingmanagementsystem.dto.request.DeleteAccountRequest;
import com.example.accountingmanagementsystem.dto.request.ListAccountDirectoryRequestDTO;
import com.example.accountingmanagementsystem.dto.request.UpdateAccountRequest;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.dto.response.GetCreditCodesResponse;
import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import com.example.accountingmanagementsystem.exception.ApiException;
import com.example.accountingmanagementsystem.repos.ChartOfAccountRepository;
import com.example.accountingmanagementsystem.services.ChartOfAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChartOfAccountServiceImp implements ChartOfAccountService {

    @Autowired
    private ChartOfAccountRepository chartOfAccountRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ApiResponse<String> addAccount(AddAccountRequest request) throws Exception {
        if (chartOfAccountRepository.existsByCreditCode(request.getCreditCode())){
            throw new ApiException("Account is already with same credit code!");
        }

        ChartOfAccount account = new ChartOfAccount();
        account.setMasterAccount(request.getMasterAccountCode());
        account.setCreditCode(request.getCreditCode());
        account.setCreditHead(request.getCreditHead());
        chartOfAccountRepository.save(account);
        return new ApiResponse<>(true, "Account is successfully added");
    }

    @Override
    public ApiResponse<Void> updateAccount(UpdateAccountRequest request) throws Exception {
        ChartOfAccount account = chartOfAccountRepository.findById(request.getId()).orElseThrow(
                () -> new ApiException("Account not found!")
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
    public ApiResponse<CustomPageResponse<ChartOfAccount>> getAccountDirectory(ListAccountDirectoryRequestDTO request) {
        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize());

        if (request.getFilters() == null){
            return new ApiResponse<>(new CustomPageResponse<>(chartOfAccountRepository.findAll(pageRequest)));
        }

        Query query = new Query();
        if (request.getFilters().getMasterAccount() != null) {
            query.addCriteria(Criteria.where("masterAccount").is(request.getFilters().getMasterAccount()));
        }

        if (request.getFilters().getCreditCode() != null) {
            query.addCriteria(Criteria.where("creditCode").is(request.getFilters().getCreditCode()));
        }

        long totalCount = mongoTemplate.count(query, ChartOfAccount.class);
        query.with(pageRequest);
        Page<ChartOfAccount> accountDirectory = PageableExecutionUtils.getPage(mongoTemplate.find(query, ChartOfAccount.class), pageRequest, () -> totalCount);
        return new ApiResponse<>(new CustomPageResponse<>(accountDirectory));
    }

    @Override
    public ApiResponse<ChartOfAccount> getAccountDetail(String accountId) {
        ChartOfAccount account = chartOfAccountRepository.findById(accountId)
                .orElseThrow(() -> new ApiException("Account not found!"));
        return new ApiResponse<>(account);
    }

    @Override
    public ApiResponse<List<GetCreditCodesResponse>> getAllCreditCodes() {
        List<GetCreditCodesResponse> response = chartOfAccountRepository.findAll()
                .stream()
                .map(chartOfAccount -> {
                    GetCreditCodesResponse creditCodesResponse = new GetCreditCodesResponse();
                    creditCodesResponse.setId(chartOfAccount.getId());
                    creditCodesResponse.setCreditCode(chartOfAccount.getCreditCode());
                    creditCodesResponse.setCreditHead(chartOfAccount.getCreditHead());
                    return creditCodesResponse;
                }).collect(Collectors.toList());
        return new ApiResponse<>(response);
    }


}
