package com.example.accountingmanagementsystem.mapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class MapperFactory {
    @Autowired
    private TenantMapper tenantMapper;
}
