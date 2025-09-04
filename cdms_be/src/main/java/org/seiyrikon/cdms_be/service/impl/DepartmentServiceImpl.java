package org.seiyrikon.cdms_be.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.seiyrikon.cdms_be.domain.model.Department;
import org.seiyrikon.cdms_be.dto.CreateDepartmentRequest;
import org.seiyrikon.cdms_be.dto.DepartmentDto;
import org.seiyrikon.cdms_be.dto.UpdateDepratmentRequest;
import org.seiyrikon.cdms_be.mapper.DepartmentMapper;
import org.seiyrikon.cdms_be.repository.DepartmentRepository;
import org.seiyrikon.cdms_be.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentDto createDepartment(CreateDepartmentRequest request) {
        Department department = new Department(request.getDepartmentName(), request.getDepartmentDescription());

        Department savedDepartment = departmentRepository.save(department);

        return departmentMapper.toDto(savedDepartment);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .map(departmentMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public DepartmentDto updateDepartment(Long id, UpdateDepratmentRequest request) {
        Department department = departmentRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Department not found with id " + id));

        department.setDepartmentName(request.getDepartmentName());
        department.setDepartmentDescription(request.getDepartmentDescription());

        Department updatedDepartment = departmentRepository.save(department);

        return departmentMapper.toDto(updatedDepartment);
    }

    @Override
    public String deleteDepartment(Long id) {
        if(!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found with id " + id);
        }

        departmentRepository.deleteById(id);

        return "Department with id " + id + " has been successfuly deleted";
    }
}
