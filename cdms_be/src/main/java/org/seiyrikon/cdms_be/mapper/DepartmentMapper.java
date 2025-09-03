package org.seiyrikon.cdms_be.mapper;

import org.seiyrikon.cdms_be.domain.model.Department;
import org.seiyrikon.cdms_be.dto.DepartmentDto;

public class DepartmentMapper {
    
    public static DepartmentDto toDto(Department d) {
        return new DepartmentDto(d.getDepartment_id(), d.getDepartment_name(), d.getDepartment_description());
    }
}
