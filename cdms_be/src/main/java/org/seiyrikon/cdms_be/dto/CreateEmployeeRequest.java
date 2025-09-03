package org.seiyrikon.cdms_be.dto;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private Long employee_department_id;
    private String employee_name, employee_email, employee_phone;
}
