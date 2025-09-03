package org.seiyrikon.cdms_be.dto;

import lombok.Data;

@Data
public class CreateDepartmentRequest {
    private String departmentName, departmentDescription;
}
