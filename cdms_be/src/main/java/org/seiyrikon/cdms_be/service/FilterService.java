package org.seiyrikon.cdms_be.service;

import java.util.List;

import org.seiyrikon.cdms_be.dto.EmployeeDto;

public interface FilterService {
    List<EmployeeDto> filterByDepartment(Long id);
}
