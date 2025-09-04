package org.seiyrikon.cdms_be.service;

import java.util.List;

import org.seiyrikon.cdms_be.dto.CreateEmployeeRequest;
import org.seiyrikon.cdms_be.dto.EmployeeDto;
import org.seiyrikon.cdms_be.dto.UpdateEmployeeRequest;

public interface EmployeeService {
    EmployeeDto createEmployee(CreateEmployeeRequest request);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto updateEmployee(Long id, UpdateEmployeeRequest request);
    String deleteEmployee(Long id);
}
