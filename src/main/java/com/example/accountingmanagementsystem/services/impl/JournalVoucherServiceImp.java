package com.example.accountingmanagementsystem.services.impl;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.dto.request.AddVoucherRequestDTO;
import com.example.accountingmanagementsystem.dto.request.ListVoucherRequestDTO;
import com.example.accountingmanagementsystem.entities.BankReceipt;
import com.example.accountingmanagementsystem.entities.JournalVoucher;
import com.example.accountingmanagementsystem.repos.JournalVoucherRepository;
import com.example.accountingmanagementsystem.services.JournalVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

@Service
public class JournalVoucherServiceImp implements JournalVoucherService {

    @Autowired
    private JournalVoucherRepository voucherRepository;


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ApiResponse<String> addVoucher(AddVoucherRequestDTO request) {
        JournalVoucher voucher = new JournalVoucher(request);
        voucherRepository.save(voucher);
        return new ApiResponse<>(voucher.getId());
    }

    @Override
    public ApiResponse<CustomPageResponse<JournalVoucher>> listVouchers(ListVoucherRequestDTO request) {
        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize());
        if (request.getFilters() == null){
            Page<JournalVoucher> pageData = voucherRepository.findAll(pageRequest);
            return new ApiResponse<>(new CustomPageResponse<>(pageData));
        }

        Query query = new Query();
        if (request.getFilters().getAccountCode() != null){
            query.addCriteria(Criteria.where("accountCode").is(request.getFilters().getAccountCode()));
        }

        if (request.getFilters().getAccountHead() != null && !request.getFilters().getAccountHead().isEmpty()){
            query.addCriteria(Criteria.where("accountHead").is(request.getFilters().getAccountHead()));
        }

        long totalCount = mongoTemplate.count(query, JournalVoucher.class);
        query.with(pageRequest);
        Page<JournalVoucher> pageData = PageableExecutionUtils.getPage(mongoTemplate.find(query, JournalVoucher.class), pageRequest, () -> totalCount);
        return new ApiResponse<>(new CustomPageResponse<>(pageData));
    }
}
