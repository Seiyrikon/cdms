package org.seiyrikon.cdms_be.dto;

import lombok.Data;

@Data
public class CreateDepartmentRequest {
    private String department_name, department_description;
}
