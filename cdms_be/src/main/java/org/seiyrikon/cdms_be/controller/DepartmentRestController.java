package org.seiyrikon.cdms_be.controller;

import java.util.List;

import org.seiyrikon.cdms_be.dto.CreateDepartmentRequest;
import org.seiyrikon.cdms_be.dto.DepartmentDto;
import org.seiyrikon.cdms_be.dto.UpdateDepratmentRequest;
import org.seiyrikon.cdms_be.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/department")
@Tag(name = "Departments", description = "Operations on departments")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    @Operation(summary = "Create a department", description = "Registers a new department, returns the information of the registered department")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody CreateDepartmentRequest request) {
        return ResponseEntity.ok(departmentService.createDepartment(request));
    }

    @GetMapping
    @Operation(summary = "Get all departments", description = "Returns the information of all the registered departments")
    public ResponseEntity<List<DepartmentDto>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get department by ID", description = "Find the department using ID, returns the information of the department")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update department information", description = "Update the information of the department, returns the updated information of the department")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id, @RequestBody UpdateDepratmentRequest request) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete department by ID", description = "Deletes the record of the department")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }
}