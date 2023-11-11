package com.example.accountingmanagementsystem.controllers;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddAccountRequest;
import com.example.accountingmanagementsystem.dto.request.DeleteAccountRequest;
import com.example.accountingmanagementsystem.dto.request.GetAccountDirectoryRequest;
import com.example.accountingmanagementsystem.dto.request.UpdateAccountRequest;
import com.example.accountingmanagementsystem.dto.CustomPageResponse;
import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import com.example.accountingmanagementsystem.services.ChartOfAccountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/accountDirectory/")
public class AccountDirectoryController {

    @Autowired
    private ChartOfAccountService chartOfAccountService;

    @PostMapping("add")
    public ResponseEntity<ApiResponse<Long>> add(@Valid @RequestBody AddAccountRequest request) throws Exception {
        ApiResponse<Long> response = chartOfAccountService.addAccount(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("update/{accountId}")
    public ResponseEntity<ApiResponse<Long>> update(@PathVariable long accountId, @Valid @RequestBody UpdateAccountRequest request) throws Exception {
        ApiResponse<Long> response = chartOfAccountService.updateAccount(accountId, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("delete")
    public ResponseEntity<ApiResponse<Long>> delete(@RequestBody DeleteAccountRequest request) throws Exception {
        ApiResponse<Long> response = chartOfAccountService.deleteAccount(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<CustomPageResponse<ChartOfAccount>>> getAccountDirectory(@RequestBody GetAccountDirectoryRequest request) throws Exception {
        ApiResponse<CustomPageResponse<ChartOfAccount>> response = chartOfAccountService.getAccountDirectory(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{accountId}")
    public ResponseEntity<ApiResponse<ChartOfAccount>> getAccountDetail(@PathVariable Long accountId) throws Exception {
        ApiResponse<ChartOfAccount> response = chartOfAccountService.getAccountDetail(accountId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
