package com.example.accountingmanagementsystem.dto.response;

public class GetCreditCodesResponse {
    private Long id;
    private Long creditCode;
    private String creditHead;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(Long creditCode) {
        this.creditCode = creditCode;
    }

    public String getCreditHead() {
        return creditHead;
    }

    public void setCreditHead(String creditHead) {
        this.creditHead = creditHead;
    }
}
