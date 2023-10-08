package com.example.accountingmanagementsystem.controllers;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddSubAccountRequestDTO;
import com.example.accountingmanagementsystem.dto.request.UpdateSubAccountRequest;
import com.example.accountingmanagementsystem.services.ChartOfAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/chart-of-account/")
public class ChartOfAccountController {

    @Autowired
    private ChartOfAccountService chartOfAccountService;

    @PostMapping("/sub-account/add")
    public ResponseEntity<ApiResponse<Long>> add(@RequestBody AddSubAccountRequestDTO request) throws Exception {
        ApiResponse<Long> response = chartOfAccountService.addAccount(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/sub-account/update/{accountId}")
    public ResponseEntity<ApiResponse<Long>> update(@PathVariable long accountId, @RequestBody UpdateSubAccountRequest request) throws Exception {
        ApiResponse<Long> response = chartOfAccountService.updateAccount(accountId, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/sub-account/delete/{accountId}")
    public ResponseEntity<ApiResponse<Long>> delete(@PathVariable long accountId) throws Exception {
        ApiResponse<Long> response = chartOfAccountService.deleteAccount(accountId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
