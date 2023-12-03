package com.example.accountingmanagementsystem.entities;

import com.example.accountingmanagementsystem.dto.request.AddBankReceiptRequestDTO;
import com.example.accountingmanagementsystem.dto.request.ChequeDetailDTO;
import com.example.accountingmanagementsystem.dto.request.UpdateBankReceiptRequestDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Getter
@Setter
public class BankReceipt {
    @Id
    private String id;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    private String voucherNo;
    private String buildingCode;
    private String buildingName;
    private String flatNo;
    private Tenant tenantDetail;
    private List<ChequeDetail> chequeDetail;

    public BankReceipt() {
    }

    public BankReceipt(AddBankReceiptRequestDTO request) {
        this.setVoucherNo(request.getVoucherNo());
        this.setBuildingName(request.getBuildingName());
        this.setBuildingCode(request.getBuildingCode());
        this.setFlatNo(request.getFlatNo());
        // tenant
        Tenant tenantDetail = new Tenant(request.getTenantDetail());
        this.setTenantDetail(tenantDetail);
        // check detail
        request.getChequeDetailList().forEach(this::addCheckDetail);
    }

    public void addCheckDetail(ChequeDetailDTO chequeDetailDTO){
        if (chequeDetail == null){
            chequeDetail = new ArrayList<>();
        }
        this.chequeDetail.add(new ChequeDetail(chequeDetailDTO));
    }

    public void updateBank(UpdateBankReceiptRequestDTO request) {
        this.setVoucherNo(request.getVoucherNo());
        this.setBuildingName(request.getBuildingName());
        this.setBuildingCode(request.getBuildingCode());
        this.setFlatNo(request.getFlatNo());

        // tenant
        Tenant tenantDetail = new Tenant(request.getTenantDetail());
        this.setTenantDetail(tenantDetail);

        // check detail
        request.getChequeDetailList().forEach(this::addCheckDetail);
    }
}
