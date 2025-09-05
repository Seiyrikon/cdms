package org.seiyrikon.cdms_be.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.seiyrikon.cdms_be.service.FilterService;
import org.seiyrikon.cdms_be.service.ReportService;
import org.seiyrikon.cdms_be.service.SearchService;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService, SearchService, FilterService, ReportService{

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

    @Override
    public List<EmployeeDto> filterByDepartment(Long id) {
        return employeeRepository.findAllByDepartment_DepartmentId(id)
                .stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long countEmployeesByDepartment(Long id) {
        return employeeRepository.countByDepartment_DepartmentId(id);
    }

    @Override
    public void exportToCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=employees.csv");
        
        List<EmployeeDto> employees = employeeRepository.findAll()
                                        .stream()
                                        .map(employeeMapper::toDto)
                                        .collect(Collectors.toList());

        PrintWriter writer = response.getWriter();

        writer.println("ID, Employee Name, Department, Employee Email, Employee Phone");
        for(EmployeeDto e : employees) {
            writer.println(String.format("%s, %s, %s, %s, %s", 
                                        e.getEmployeeId().toString(), 
                                        e.getEmployeeName().toString(), 
                                        e.getDepartment().getDepartmentName().toString(), 
                                        e.getEmployeeEmail().toString(), 
                                        e.getEmployeePhone().toString()));
        }
        writer.flush();
    }
    
}
