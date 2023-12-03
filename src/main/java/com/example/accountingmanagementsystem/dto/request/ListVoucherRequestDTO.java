package com.example.accountingmanagementsystem.dto.request;

import lombok.Data;

@Data
public class ListVoucherRequestDTO {
    private Integer pageNumber;
    private Integer pageSize;
    private ListVoucherFilter filters;
}
