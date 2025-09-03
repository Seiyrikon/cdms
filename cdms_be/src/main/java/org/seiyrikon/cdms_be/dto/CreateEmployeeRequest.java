package org.seiyrikon.cdms_be.dto;

import org.seiyrikon.cdms_be.domain.model.Department;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private Department department;
    private String employee_name, employee_email, employee_phone;
}
