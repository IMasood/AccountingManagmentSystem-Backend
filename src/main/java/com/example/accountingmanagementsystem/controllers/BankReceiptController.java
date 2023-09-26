package com.example.accountingmanagementsystem.controllers;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddBankReceiptRequest;
import com.example.accountingmanagementsystem.dto.response.BankReceiptDTO;
import com.example.accountingmanagementsystem.services.BankReceiptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/bank/receipt/")
public class BankReceiptController {


    @Autowired
    private BankReceiptService bankReceiptService;

    @PostMapping("add")
    public ResponseEntity<ApiResponse<String>> addReceipt(@RequestBody AddBankReceiptRequest request){
        ApiResponse<String> response = bankReceiptService.addReceipt(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("list")
    public ResponseEntity<ApiResponse<BankReceiptDTO>> listReceipts(){
        ApiResponse<BankReceiptDTO> response = bankReceiptService.listReceipts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
