package org.seiyrikon.cdms_be.controller;

import java.util.List;

import org.seiyrikon.cdms_be.dto.CreateEmployeeRequest;
import org.seiyrikon.cdms_be.dto.EmployeeDto;
import org.seiyrikon.cdms_be.dto.UpdateEmployeeRequest;
import org.seiyrikon.cdms_be.service.EmployeeService;
import org.seiyrikon.cdms_be.service.SearchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/employee")
@Tag(name = "Employees", description = "Operations on employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final SearchService searchService;

    public EmployeeRestController(EmployeeService employeeService, SearchService searchService) {
        this.employeeService = employeeService;
        this.searchService = searchService;
    }

    @PostMapping
    @Operation(summary = "Create an employee", description = "Registers a new employee, returns the information of the registered employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody CreateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.createEmployee(request));
    }
    
    @GetMapping
    @Operation(summary = "Get all employees", description = "Returns the information of all the registered employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get employee by ID", description = "Find the employee using ID, returns the information of the employee")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update employee information", description = "Update the information of the employee, returns the updated information of the employee")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete employee by ID", description = "Deletes the record of the employee")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    @GetMapping("/search/by-name")
    @Operation(summary = "Search employee by name", description = "Find the employee using name, returns the information of the employee")
    public ResponseEntity<EmployeeDto> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(searchService.search(name));
    }

    @GetMapping("/search/by-department")
    @Operation(summary = "Search employee by department", description = "Find the employee using department, returns the information of the employees")
    public ResponseEntity<List<EmployeeDto>> searchByDepartment(@RequestParam Long id) {
        return ResponseEntity.ok(searchService.search(id));
    }
}
