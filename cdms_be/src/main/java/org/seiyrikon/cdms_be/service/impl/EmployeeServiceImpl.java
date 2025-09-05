package org.seiyrikon.cdms_be.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.seiyrikon.cdms_be.domain.model.Department;
import org.seiyrikon.cdms_be.domain.model.Employee;
import org.seiyrikon.cdms_be.dto.CreateEmployeeRequest;
import org.seiyrikon.cdms_be.dto.EmployeeDto;
import org.seiyrikon.cdms_be.dto.UpdateEmployeeRequest;
import org.seiyrikon.cdms_be.mapper.EmployeeMapper;
import org.seiyrikon.cdms_be.repository.DepartmentRepository;
import org.seiyrikon.cdms_be.repository.EmployeeRepository;
import org.seiyrikon.cdms_be.service.EmployeeService;
import org.seiyrikon.cdms_be.service.SearchService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService, SearchService{

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployeeDto createEmployee(CreateEmployeeRequest request) {
        Department department = departmentRepository.findById(request.getDepartment().getDepartmentId())
                                .orElseThrow(() -> new RuntimeException("Department not found"));

        Employee employee = new Employee(department, request.getEmployeeName(), request.getEmployeeEmail(), request.getEmployeePhone());
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public EmployeeDto updateEmployee(Long id, UpdateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));

        Department department = departmentRepository.findById(request.getDepartment().getDepartmentId())
                                .orElseThrow(() -> new RuntimeException("Department not found with id " + request.getDepartment().getDepartmentId()));

        employee.setEmployeeName(request.getEmployeeName());
        employee.setEmployeeEmail(request.getEmployeeEmail());
        employee.setEmployeePhone(request.getEmployeePhone());
        employee.setDepartment(department);

        Employee updatedEmployee = employeeRepository.save(employee);

        return employeeMapper.toDto(updatedEmployee);
    }

    @Override
    public String deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id " + id);
        }

        employeeRepository.deleteById(id);

        return "Employee with id " + id + " has been deleted successfully!";
    }

    @Override
    public EmployeeDto searchByName(String name) {
        return employeeRepository.findByEmployeeName(name)
                .map(employeeMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Employee not found with name " + name));
    }

    @Override
    public List<EmployeeDto> searchByDepartment(Long id) {
        return employeeRepository.findAllByDepartment_DepartmentId(id)
                .stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }
    
}
