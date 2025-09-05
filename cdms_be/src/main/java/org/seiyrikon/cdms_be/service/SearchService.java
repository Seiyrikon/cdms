package org.seiyrikon.cdms_be.service;

import java.util.List;

import org.seiyrikon.cdms_be.dto.EmployeeDto;

public interface SearchService {
    EmployeeDto search(String name);
    List<EmployeeDto> search(Long id);
}
