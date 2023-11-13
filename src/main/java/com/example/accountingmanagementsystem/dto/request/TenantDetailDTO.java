package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TenantDetailDTO {
    private String tenantName;
    private String tenantNo;
    private String periodOfContract;
    private LocalDateTime from;
    private LocalDateTime to;
    private LocalDateTime fasDate;
    private BigDecimal parkingCharges1;
    private BigDecimal parkingCharges2;
    private List<CreditDetailDTO> creditDetailList;
}
