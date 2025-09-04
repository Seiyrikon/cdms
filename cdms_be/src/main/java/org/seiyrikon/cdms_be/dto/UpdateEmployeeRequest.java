package org.seiyrikon.cdms_be.dto;

import org.seiyrikon.cdms_be.domain.model.Department;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {
    private Department department;
    String employeeName, employeeEmail, employeePhone;
}
