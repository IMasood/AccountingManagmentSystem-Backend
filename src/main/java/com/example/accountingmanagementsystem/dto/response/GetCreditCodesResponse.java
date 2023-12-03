package com.example.accountingmanagementsystem.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCreditCodesResponse {
    private String id;
    private Long creditCode;
    private String creditHead;
}
