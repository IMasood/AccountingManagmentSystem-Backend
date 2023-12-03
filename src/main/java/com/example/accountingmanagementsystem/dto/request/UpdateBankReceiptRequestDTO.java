package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class UpdateBankReceiptRequestDTO{
    private String bankReceiptId;
    private String voucherNo;
    private String buildingCode;
    private String buildingName;
    private String flatNo;
    private TenantDetailDTO tenantDetail;
    private List<ChequeDetailDTO> chequeDetailList;
}
