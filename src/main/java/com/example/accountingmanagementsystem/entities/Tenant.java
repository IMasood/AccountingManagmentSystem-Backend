package com.example.accountingmanagementsystem.entities;


import com.example.accountingmanagementsystem.dto.request.CreditDetailDTO;
import com.example.accountingmanagementsystem.dto.request.TenantDetailDTO;
import com.example.accountingmanagementsystem.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Tenant {
    private String tenantNo;
    private String name;
    private Date periodOfContractFromDate;
    private Date periodOfContractToDate;
    private Date fasDate;
    private BigDecimal parkingCharges1;
    private BigDecimal parkingCharges2;
    private String additionalInfo;
    private List<CreditDetails> creditDetails;

    public Tenant() {
    }

    public Tenant(TenantDetailDTO tenantDetailDTO) {
        this.setTenantNo(tenantDetailDTO.getTenantNo());
        this.setName(tenantDetailDTO.getTenantName());
        this.setAdditionalInfo(tenantDetailDTO.getAdditionalInfo());
        this.setFasDate(DateUtils.parseDate(tenantDetailDTO.getFasDate()));
        this.setPeriodOfContractFromDate(DateUtils.parseDate(tenantDetailDTO.getPeriodOfContractFrom()));
        this.setPeriodOfContractToDate(DateUtils.parseDate(tenantDetailDTO.getPeriodOfContractTo()));
        this.setParkingCharges1(tenantDetailDTO.getParkingCharges1());
        this.setParkingCharges2(tenantDetailDTO.getParkingCharges2());
        tenantDetailDTO.getCreditDetailList().forEach(this::addCreditDetail);
    }


    public void addCreditDetail(CreditDetailDTO dto){
        if (creditDetails == null){
            creditDetails = new ArrayList<>();
        }
        this.creditDetails.add(new CreditDetails(dto));
    }


}
