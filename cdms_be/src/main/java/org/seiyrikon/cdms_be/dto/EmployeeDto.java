package org.seiyrikon.cdms_be.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    
    private Long employee_id, employee_department_id;
    private String employee_name, employee_email, employee_phone;

    public EmployeeDto(Long employee_id, Long employee_department_id, String employee_name, String employee_email, String employee_phone) {
        this.employee_id = employee_id;
        this.employee_department_id = employee_department_id;
        this.employee_name = employee_name;
        this.employee_email = employee_email;
        this.employee_phone = employee_phone;
    }
}
