package com.example.accountingmanagementsystem.repos;

import com.example.accountingmanagementsystem.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepo extends JpaRepository<Tenant, Long> {
}
