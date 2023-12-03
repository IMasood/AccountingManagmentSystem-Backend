package com.example.accountingmanagementsystem.entities;

import com.example.accountingmanagementsystem.dto.request.CreditDetailDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreditDetails{
    private String creditCode;
    private String creditHead;
    private BigDecimal amount;

    public CreditDetails() {
    }

    public CreditDetails(CreditDetailDTO detailDTO) {
        this.creditCode = detailDTO.getCreditCode();
        this.creditHead = detailDTO.getCreditHead();
        this.amount = detailDTO.getAmount();
    }
}
