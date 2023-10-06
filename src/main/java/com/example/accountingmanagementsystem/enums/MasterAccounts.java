package com.example.accountingmanagementsystem.enums;

public enum MasterAccounts {

    ASSET("Asset", "", "101-199"),
    LIABILITY("Liability", "", "201-299"),
    EQUITY("Equity", "", "301-399"),
    REVENUE("Revenue", "", "401-499"),
    EXPENSE("Expense", "", "501-599");

    private String name;
    private String description;
    private String subAccountRange;
    MasterAccounts(String name, String description, String range) {
        this.name = name;
        this.description = description;
        this.subAccountRange = range;
    }
}
