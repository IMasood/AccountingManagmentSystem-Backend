package com.example.accountingmanagementsystem.services;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddBankReceiptRequest;
import com.example.accountingmanagementsystem.dto.response.BankReceiptDTO;
import org.springframework.stereotype.Service;

@Service
public interface BankReceiptService {
    public ApiResponse<String> addReceipt(AddBankReceiptRequest request);
    ApiResponse<BankReceiptDTO> listReceipts();
}
