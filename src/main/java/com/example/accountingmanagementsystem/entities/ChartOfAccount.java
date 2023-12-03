package com.example.accountingmanagementsystem.entities;

//import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Document
public class ChartOfAccount{

    @Id
    private String id;
    private Long masterAccount;
    private Long creditCode;
    private String creditHead;
    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;
}
