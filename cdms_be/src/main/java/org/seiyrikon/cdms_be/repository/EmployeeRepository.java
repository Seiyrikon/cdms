package org.seiyrikon.cdms_be.repository;

import org.seiyrikon.cdms_be.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
