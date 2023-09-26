package com.example.accountingmanagementsystem.mapper;

import com.example.accountingmanagementsystem.dto.request.AddTenantRequestDTO;
import com.example.accountingmanagementsystem.dto.response.TenantResponseDTO;
import com.example.accountingmanagementsystem.entities.Tenant;
import org.springframework.stereotype.Component;

@Component
public class TenantMapper extends BaseMapper {

    public Tenant add(AddTenantRequestDTO model) {
        Tenant tenant = new Tenant();
        tenant.setTenantNo(model.getTenantNo());
        tenant.setName(model.getName());

        return tenant;

    }


    public TenantResponseDTO find(Tenant tenant) {
        TenantResponseDTO responseDTO = new TenantResponseDTO();
        responseDTO.setId(tenant.getId());
        responseDTO.setName(tenant.getName());
        responseDTO.setTenantNo(tenant.getTenantNo());
        return responseDTO;
    }
}
