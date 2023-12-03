package com.example.accountingmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class AccountingManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountingManagementSystemApplication.class, args);
    }

}
