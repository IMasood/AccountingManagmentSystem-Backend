package com.example.accountingmanagementsystem.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractDetailDTO {
    private String periodOfContract;
    private LocalDateTime from;
    private LocalDateTime to;
    private LocalDateTime fasDate;
    private BigDecimal parkingCharges1;
    private BigDecimal parkingCharges2;
}
