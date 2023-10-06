package com.example.accountingmanagementsystem.repos;

import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartOfAccountRepository extends JpaRepository<ChartOfAccount, Long> {

    boolean existsByAccountCode(long code);
}
