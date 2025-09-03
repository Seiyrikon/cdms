package org.seiyrikon.cdms_be.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private Long departmentId;
    private String departmentName, departmentDescription;

    public DepartmentDto(Long departmentId, String departmentName, String departmentDescription) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
    }
}
