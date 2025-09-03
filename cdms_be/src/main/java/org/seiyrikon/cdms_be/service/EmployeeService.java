package org.seiyrikon.cdms_be.service;

import org.seiyrikon.cdms_be.dto.CreateEmployeeRequest;
import org.seiyrikon.cdms_be.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(CreateEmployeeRequest request);
}
