package org.seiyrikon.cdms_be.mapper;

import org.seiyrikon.cdms_be.domain.model.Employee;
import org.seiyrikon.cdms_be.dto.EmployeeDto;

public class EmployeeMapper {
    
    public static EmployeeDto toDto(Employee e) {
        return new EmployeeDto(e.getEmployee_id(), e.getDepartment(), e.getEmployee_name(), e.getEmployee_email(), e.getEmployee_phone());
    }
}
