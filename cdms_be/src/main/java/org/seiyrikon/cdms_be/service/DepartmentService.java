package org.seiyrikon.cdms_be.service;

import java.util.List;

import org.seiyrikon.cdms_be.dto.CreateDepartmentRequest;
import org.seiyrikon.cdms_be.dto.DepartmentDto;
import org.seiyrikon.cdms_be.dto.UpdateDepratmentRequest;

public interface DepartmentService {
    DepartmentDto createDepartment(CreateDepartmentRequest request);
    List<DepartmentDto> getAllDepartment();
    DepartmentDto getDepartmentById(Long id);
    DepartmentDto updateDepartment(Long id, UpdateDepratmentRequest request);
    String deleteDepartment(Long id);
}
