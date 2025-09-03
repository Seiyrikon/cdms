package org.seiyrikon.cdms_be.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private Long department_id;
    private String department_name, department_description;

    public DepartmentDto(Long department_id, String department_name, String department_description) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.department_description = department_description;
    }
}
