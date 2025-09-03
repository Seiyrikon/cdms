package org.seiyrikon.cdms_be.repository;

import org.seiyrikon.cdms_be.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
