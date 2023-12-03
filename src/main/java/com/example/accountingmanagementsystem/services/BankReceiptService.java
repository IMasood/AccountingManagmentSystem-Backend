package com.example.accountingmanagementsystem.services;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.dto.request.AddBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.dto.request.ListBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.dto.request.UpdateBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.entities.BankReceipt;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface BankReceiptService {
    ApiResponse<String> addReceipt(AddBankReceiptRequestDTO request) throws ParseException;
    ApiResponse<CustomPageResponse<BankReceipt>> listBankReceipts(ListBankReceiptRequestDTO request);

    ApiResponse<BankReceipt> getBankReceiptDetail(String bankReceiptId);

    ApiResponse<Void> updateBankReceipt(UpdateBankReceiptRequestDTO request);

    ApiResponse<Void> deleteBankReceipt(String bankReceiptId);
}
