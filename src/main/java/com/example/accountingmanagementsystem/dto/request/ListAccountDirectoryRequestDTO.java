package com.example.accountingmanagementsystem.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListAccountDirectoryRequestDTO {
    @NotNull
    private Integer pageNumber;
    @NotNull
    private Integer pageSize;

    private AccountDirectoryFilter filters;
}
