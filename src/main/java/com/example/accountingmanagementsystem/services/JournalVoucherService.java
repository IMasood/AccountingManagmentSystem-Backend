package com.example.accountingmanagementsystem.services;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.dto.request.AddVoucherRequestDTO;
import com.example.accountingmanagementsystem.dto.request.ListVoucherRequestDTO;
import com.example.accountingmanagementsystem.entities.JournalVoucher;

public interface JournalVoucherService {
    ApiResponse<String> addVoucher(AddVoucherRequestDTO request);
    ApiResponse<CustomPageResponse<JournalVoucher>> listVouchers(ListVoucherRequestDTO request);
}
