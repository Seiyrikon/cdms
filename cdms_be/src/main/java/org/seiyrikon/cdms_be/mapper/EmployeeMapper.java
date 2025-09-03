package org.seiyrikon.cdms_be.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.seiyrikon.cdms_be.domain.model.Employee;
import org.seiyrikon.cdms_be.dto.EmployeeDto;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    
    @Mapping(source = "department", target = "department")
    EmployeeDto toDto(Employee employee);

    @Mapping(source = "department", target = "department")
    @Mapping(target = "createdAt", ignore = true)
    Employee toEntity(EmployeeDto employeeDto);
}
