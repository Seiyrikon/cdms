package org.seiyrikon.cdms_be.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.seiyrikon.cdms_be.domain.model.Department;
import org.seiyrikon.cdms_be.dto.DepartmentDto;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    
    DepartmentDto toDto(Department department);

    @Mapping(target = "createdAt", ignore = true)
    Department toEntity(DepartmentDto dto);
}
