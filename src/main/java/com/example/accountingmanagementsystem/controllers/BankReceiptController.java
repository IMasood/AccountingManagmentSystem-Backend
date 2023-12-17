package com.example.accountingmanagementsystem.controllers;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.dto.request.AddBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.dto.request.ListBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.dto.request.UpdateBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.entities.BankReceipt;
import com.example.accountingmanagementsystem.services.BankReceiptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping(value = "api/v1/bank/receipt/")
public class BankReceiptController {


    @Autowired
    private BankReceiptService bankReceiptService;

    @PostMapping("add")
    public ResponseEntity<ApiResponse<String>> addReceipt(@RequestBody AddBankReceiptRequestDTO request) throws ParseException {
        log.info("addReceipt() -> request received to add bank receipt : {}", request);
        ApiResponse<String> response = bankReceiptService.addReceipt(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("list")
    public ResponseEntity<ApiResponse<CustomPageResponse<BankReceipt>>> listReceipts(@RequestBody ListBankReceiptRequestDTO request){
        log.info("listBankReceipts() -> request received to list bank receipt : {}", request);
        ApiResponse<CustomPageResponse<BankReceipt>> response = bankReceiptService.listBankReceipts(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("get-receipt-detail")
    public ResponseEntity<ApiResponse<BankReceipt>> getBankReceiptDetail(@RequestParam String bankReceiptId){
        log.info("getBankReceiptDetail() -> request received get bank receipt : {}", bankReceiptId);
        ApiResponse<BankReceipt> response = bankReceiptService.getBankReceiptDetail(bankReceiptId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse<Void>> updateBankReceipt(@RequestBody UpdateBankReceiptRequestDTO request){
        log.info("updateBankReceipt() -> request received update bank receipt : {}", request);
        ApiResponse<Void> response = bankReceiptService.updateBankReceipt(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<ApiResponse<Void>> deleteBankReceipt(@RequestParam String bankReceiptId){
        log.info("deleteBankReceipt() -> request received delete bank receipt : {}", bankReceiptId);
        ApiResponse<Void> response = bankReceiptService.deleteBankReceipt(bankReceiptId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
