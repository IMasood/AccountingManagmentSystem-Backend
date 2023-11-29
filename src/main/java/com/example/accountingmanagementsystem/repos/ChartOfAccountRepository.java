package com.example.accountingmanagementsystem.repos;

import com.example.accountingmanagementsystem.entities.ChartOfAccount;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface ChartOfAccountRepository extends MongoRepository<ChartOfAccount, String> {
    boolean existsByCreditCode(long code);
}
