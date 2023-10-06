package com.example.accountingmanagementsystem.controllers;

import com.example.accountingmanagementsystem.dto.ApiResponse;
import com.example.accountingmanagementsystem.dto.request.AddSubAccountRequest;
import com.example.accountingmanagementsystem.services.ChartOfAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/chart-of-account/")
public class ChartOfAccountController {

    @Autowired
    private ChartOfAccountService chartOfAccountService;
    @PostMapping("/sub-account/add")
    public ResponseEntity<ApiResponse<Long>> addSubAccount(@RequestBody AddSubAccountRequest request){
        ApiResponse<Long> response = chartOfAccountService.addSubAccount(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
