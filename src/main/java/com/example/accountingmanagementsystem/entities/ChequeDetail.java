package com.example.accountingmanagementsystem.entities;

import com.example.accountingmanagementsystem.dto.request.ChequeDetailDTO;
import com.example.accountingmanagementsystem.utils.DateUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Setter
@Getter
public class ChequeDetail{
    private Date chequeDate;
    private String chequeDetail;
    private String drAccount;
    private String bankName;
    private String depositBank;
    private String drawnBank;
    private String chequeNumber;
    private BigDecimal amount;

    public ChequeDetail() {
    }

    public ChequeDetail(ChequeDetailDTO chequeDetailDTO) {
        this.chequeDetail = chequeDetailDTO.getChequeDetail();
        this.bankName = chequeDetailDTO.getBankName();
        this.chequeNumber = chequeDetailDTO.getBankName();
        this.amount = chequeDetailDTO.getAmount();
        this.drAccount = chequeDetailDTO.getDrAccount();
        this.drawnBank = chequeDetailDTO.getDrawnBank();
        this.depositBank = chequeDetailDTO.getDepositBank();
        this.chequeDate = DateUtils.parseDate(chequeDetailDTO.getChequeDate());
    }
}
