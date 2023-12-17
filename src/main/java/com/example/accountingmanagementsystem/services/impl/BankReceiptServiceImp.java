package com.example.accountingmanagementsystem.services.impl;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.dto.request.AddBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.dto.request.ListBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.dto.request.UpdateBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.entities.BankReceipt;
import com.example.accountingmanagementsystem.exception.ApiException;
import com.example.accountingmanagementsystem.repos.BankReceiptRepository;
import com.example.accountingmanagementsystem.services.BankReceiptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Slf4j
@Service
public class BankReceiptServiceImp implements BankReceiptService {

    @Autowired
    private BankReceiptRepository bankReceiptRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ApiResponse<String> addReceipt(AddBankReceiptRequestDTO request) throws ParseException {
        BankReceipt newBankReceipt = new BankReceipt(request);
        bankReceiptRepository.save(newBankReceipt);
        return new ApiResponse<>(true,"receipt is successfully add");
    }

    @Override
    public ApiResponse<CustomPageResponse<BankReceipt>> listBankReceipts(ListBankReceiptRequestDTO request) {
        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize());
        if (request.getFilters() == null){
            Page<BankReceipt> pageData = bankReceiptRepository.findAll(pageRequest);
            return new ApiResponse<>(new CustomPageResponse<>(pageData));
        }

        Query query = new Query();
        if (request.getFilters().getVoucherNo() != null && !request.getFilters().getVoucherNo().isEmpty()){
            query.addCriteria(Criteria.where("voucherNo").is(request.getFilters().getVoucherNo()));
        }

        if (request.getFilters().getFlatNo() != null && !request.getFilters().getFlatNo().isEmpty()){
            query.addCriteria(Criteria.where("flatNo").is(request.getFilters().getFlatNo()));
        }

        long totalCount = mongoTemplate.count(query, BankReceipt.class);
        query.with(pageRequest);
        Page<BankReceipt> pageData = PageableExecutionUtils.getPage(mongoTemplate.find(query, BankReceipt.class), pageRequest, () -> totalCount);
        return new ApiResponse<>(new CustomPageResponse<>(pageData));
    }

    @Override
    public ApiResponse<BankReceipt> getBankReceiptDetail(String bankReceiptId) {
        BankReceipt bankReceipt = bankReceiptRepository.findById(bankReceiptId)
                .orElseThrow(() -> new ApiException("Bank Receipt Not found!"));
        return new ApiResponse<>(bankReceipt);
    }

    @Override
    public ApiResponse<Void> updateBankReceipt(UpdateBankReceiptRequestDTO request) {
        BankReceipt bankReceipt = bankReceiptRepository.findById(request.getBankReceiptId())
                .orElseThrow(() -> new ApiException("Bank Receipt not found!"));
        bankReceipt.updateBank(request);
        bankReceiptRepository.save(bankReceipt);
        return new ApiResponse<>(true, "Bank Receipt is successfully updated!");
    }

    @Override
    public ApiResponse<Void> deleteBankReceipt(String bankReceiptId) {
        bankReceiptRepository.deleteById(bankReceiptId);
        return new ApiResponse<>(true, "Bank Receipt is successfully deleted!");
    }
}
