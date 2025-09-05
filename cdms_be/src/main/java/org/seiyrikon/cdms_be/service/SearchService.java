package org.seiyrikon.cdms_be.service;

import java.util.List;

import org.seiyrikon.cdms_be.dto.EmployeeDto;

public interface SearchService {
    EmployeeDto searchByName(String name);
    List<EmployeeDto> searchByDepartment(Long id);
}
