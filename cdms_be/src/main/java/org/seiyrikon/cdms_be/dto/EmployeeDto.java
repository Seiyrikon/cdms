package org.seiyrikon.cdms_be.dto;

import org.seiyrikon.cdms_be.domain.model.Department;

import lombok.Data;

@Data
public class EmployeeDto {
    
    private Long employee_id;
    private Department department;
    private String employee_name, employee_email, employee_phone;

    public EmployeeDto(Long employee_id, Department department, String employee_name, String employee_email, String employee_phone) {
        this.employee_id = employee_id;
        this.department = department;
        this.employee_name = employee_name;
        this.employee_email = employee_email;
        this.employee_phone = employee_phone;
    }
}
