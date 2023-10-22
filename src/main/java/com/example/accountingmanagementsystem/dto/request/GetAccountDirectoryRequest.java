package com.example.accountingmanagementsystem.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAccountDirectoryRequest {
    private Long filterByMasterAccount;
    private Long filterByCreditCode;
    @NotNull
    private Integer pageNumber;
    @NotNull
    private Integer pageSize;
}
