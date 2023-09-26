package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class TenantDetailDTO {
    private String tenantName;
    private String tenantNo;
    private List<CreditDetailDTO> creditDetailList;
}
