package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ChequeDetailDTO {
    private LocalDateTime chequeDate;
    private String chequeDetail;
    private String drAccount;
    private String bankName;
    private String depositBank;
    private String drawnBank;
    private String chequeNumber;
    private BigDecimal amount;
}
