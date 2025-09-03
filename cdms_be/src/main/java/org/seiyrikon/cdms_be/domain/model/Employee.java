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
    private Long employee_id;

    @ManyToOne
    @JoinColumn(name = "employee_department_id", referencedColumnName = "department_id", nullable = true)
    private Department department;

    @Column(name = "employee_name", nullable = false, length = 50)
    private String employee_name;
    
    @Column(name = "employee_email", nullable = false, unique = true, length = 100)
    private String employee_email;
    
    @Column(name = "employee_phone", nullable = false, length = 15)
    private String employee_phone;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    protected Employee() {}

    public Employee(Department department, String employee_name, String employee_email, String employee_phone) {
        this.department = department;
        this.employee_name = employee_name;
        this.employee_email = employee_email;
        this.employee_phone = employee_phone;
        this.created_at = LocalDateTime.now();
    }
}
