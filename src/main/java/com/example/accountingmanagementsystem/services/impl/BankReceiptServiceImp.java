package com.example.accountingmanagementsystem.services.impl;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddBankReceiptRequest;
import com.example.accountingmanagementsystem.dto.response.BankReceiptDTO;
import com.example.accountingmanagementsystem.services.BankReceiptService;
import org.springframework.stereotype.Service;

@Service
public class BankReceiptServiceImp implements BankReceiptService {
    @Override
    public ApiResponse<String> addReceipt(AddBankReceiptRequest request) {
        return new ApiResponse<>(true,"receipt is successfully add");
    }

    @Override
    public ApiResponse<BankReceiptDTO> listReceipts() {
        return new ApiResponse<>(new BankReceiptDTO());
    }
}
