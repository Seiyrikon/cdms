package org.seiyrikon.cdms_be.controller;

import java.util.List;

import org.seiyrikon.cdms_be.dto.CreateDepartmentRequest;
import org.seiyrikon.cdms_be.dto.DepartmentDto;
import org.seiyrikon.cdms_be.dto.UpdateDepratmentRequest;
import org.seiyrikon.cdms_be.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/department")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody CreateDepartmentRequest request) {
        return ResponseEntity.ok(departmentService.createDepartment(request));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id, @RequestBody UpdateDepratmentRequest request) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }
}