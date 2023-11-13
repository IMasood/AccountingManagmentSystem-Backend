package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class AddBankReceiptRequest {
    private String voucherNo;
    private String buildingCode;
    private String buildingName;
    private String flatNo;
    private TenantDetailDTO tenantDetail;
    private List<ChequeDetailDTO> chequeDetailList;
}
