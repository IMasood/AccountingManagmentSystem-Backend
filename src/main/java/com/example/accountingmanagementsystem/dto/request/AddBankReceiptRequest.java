package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

@Data
public class AddBankReceiptRequest {
    private String voucherNo;
    private String buildingCode;
    private String buildingName;
    private String flatNo;
    private TenantDetailDTO tenantDetail;
    private ContractDetailDTO contractDetail;
    private ChequeDetailDTO chequeDetailList;
}
