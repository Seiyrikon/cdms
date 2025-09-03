package org.seiyrikon.cdms_be.dto;


import org.seiyrikon.cdms_be.domain.model.Department;

import lombok.Data;

@Data
public class EmployeeDto {
    
    private Long employeeId;
    private Department department;
    private String employeeName, employeeEmail, employeePhone;

    public EmployeeDto(Long employeeId, Department department, String employeeName, String employeeEmail, String employeePhone) {
        this.employeeId = employeeId;
        this.department = department;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
    }
}
