package com.example.accountingmanagementsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteAccountRequest {
    private List<String> accountIds;
}
