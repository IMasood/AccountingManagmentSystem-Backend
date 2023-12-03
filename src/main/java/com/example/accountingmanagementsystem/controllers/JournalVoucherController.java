package com.example.accountingmanagementsystem.controllers;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.dto.request.AddBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.dto.request.AddVoucherRequestDTO;
import com.example.accountingmanagementsystem.dto.request.ListVoucherRequestDTO;
import com.example.accountingmanagementsystem.entities.JournalVoucher;
import com.example.accountingmanagementsystem.services.JournalVoucherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/journal-voucher/*")
public class JournalVoucherController {

    @Autowired
    private JournalVoucherService journalVoucherService;

    @PostMapping("add-voucher")
    public ResponseEntity<ApiResponse<String>> addVoucher(@RequestBody AddVoucherRequestDTO request) throws ParseException {
        log.info("addVoucher() -> request received to add voucher : {}", request);
        ApiResponse<String> response = journalVoucherService.addVoucher(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("list-vouchers")
    public ResponseEntity<ApiResponse<CustomPageResponse<JournalVoucher>>> listVouchers(@RequestBody ListVoucherRequestDTO request) throws ParseException {
        log.info("addVoucher() -> request received to add voucher : {}", request);
        ApiResponse<CustomPageResponse<JournalVoucher>> response = journalVoucherService.listVouchers(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
