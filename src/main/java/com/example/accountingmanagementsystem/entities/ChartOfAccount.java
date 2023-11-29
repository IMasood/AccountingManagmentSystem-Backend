package com.example.accountingmanagementsystem.entities;

//import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
//@Entity
@Document
public class ChartOfAccount{

    @Id
    private String id;
    private Long masterAccount;
    private Long creditCode;
    private String creditHead;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
