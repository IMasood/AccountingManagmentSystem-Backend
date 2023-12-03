package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TenantDetailDTO {
    private String tenantName;
    private String tenantNo;
    private String  periodOfContractFrom;
    private String periodOfContractTo;
    private String  fasDate;
    private BigDecimal parkingCharges1;
    private BigDecimal parkingCharges2;
    private String additionalInfo;
    private List<CreditDetailDTO> creditDetailList;
}
