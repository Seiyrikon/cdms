package org.seiyrikon.cdms_be.service;

import org.seiyrikon.cdms_be.dto.EmployeeDto;

public interface SearchService {
    EmployeeDto search(String name);
}
