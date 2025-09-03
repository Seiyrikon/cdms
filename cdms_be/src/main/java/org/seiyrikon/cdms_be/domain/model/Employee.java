package org.seiyrikon.cdms_be.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "employee_department_id", referencedColumnName = "department_id", nullable = true)
    private Department department;

    @Column(name = "employee_name", nullable = false, length = 50)
    private String employeeName;
    
    @Column(name = "employee_email", nullable = false, unique = true, length = 100)
    private String employeeEmail;
    
    @Column(name = "employee_phone", nullable = false, length = 15)
    private String employeePhone;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    protected Employee() {}

    public Employee(Department department, String employeeName, String employeeEmail, String employeePhone) {
        this.department = department;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.createdAt = LocalDateTime.now();
    }
}
