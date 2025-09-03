package org.seiyrikon.cdms_be.service.impl;

import org.seiyrikon.cdms_be.domain.model.Employee;
import org.seiyrikon.cdms_be.dto.CreateEmployeeRequest;
import org.seiyrikon.cdms_be.dto.EmployeeDto;
import org.seiyrikon.cdms_be.mapper.EmployeeMapper;
import org.seiyrikon.cdms_be.repository.EmployeeRepository;
import org.seiyrikon.cdms_be.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(CreateEmployeeRequest request) {
        Employee employee = new Employee(request.getDepartment(), request.getEmployee_name(), request.getEmployee_email(), request.getEmployee_phone());
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDto(savedEmployee);
    }
    
}
