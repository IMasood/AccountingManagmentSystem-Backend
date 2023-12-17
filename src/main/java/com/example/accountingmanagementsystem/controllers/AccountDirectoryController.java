package com.example.accountingmanagementsystem.controllers;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddAccountRequest;
import com.example.accountingmanagementsystem.dto.request.DeleteAccountRequest;
import com.example.accountingmanagementsystem.dto.request.ListAccountDirectoryRequestDTO;
import com.example.accountingmanagementsystem.dto.request.UpdateAccountRequest;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.dto.response.GetCreditCodesResponse;
import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import com.example.accountingmanagementsystem.services.ChartOfAccountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Slf4j
@RestController
@RequestMapping(value = "api/v1/accountDirectory/")
public class AccountDirectoryController {

    @Autowired
    private ChartOfAccountService chartOfAccountService;

    @PostMapping("add")
    public ResponseEntity<ApiResponse<String>> add(@Valid @RequestBody AddAccountRequest request) throws Exception {
        ApiResponse<String> response = chartOfAccountService.addAccount(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<ApiResponse<Void>> update(@Valid @RequestBody UpdateAccountRequest request) throws Exception {
        ApiResponse<Void> response = chartOfAccountService.updateAccount(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("delete")
    public ResponseEntity<ApiResponse<Void>> delete(@RequestBody DeleteAccountRequest request) throws Exception {
        ApiResponse<Void> response = chartOfAccountService.deleteAccount(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<CustomPageResponse<ChartOfAccount>>> getAccountDirectory(@RequestBody ListAccountDirectoryRequestDTO request) throws Exception {
        ApiResponse<CustomPageResponse<ChartOfAccount>> response = chartOfAccountService.getAccountDirectory(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("get-account-detail")
    public ResponseEntity<ApiResponse<ChartOfAccount>> getAccountDetail(@RequestParam String accountId) throws Exception {
        ApiResponse<ChartOfAccount> response = chartOfAccountService.getAccountDetail(accountId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("get-all-credit-codes")
    public ResponseEntity<ApiResponse<List<GetCreditCodesResponse>>> getAllCreditCodes() throws Exception {
        ApiResponse<List<GetCreditCodesResponse>> allCreditCodes = chartOfAccountService.getAllCreditCodes();
        return new ResponseEntity<>(allCreditCodes, HttpStatus.OK);
    }


}
