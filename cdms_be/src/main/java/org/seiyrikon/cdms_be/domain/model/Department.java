package org.seiyrikon.cdms_be.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @Column(name = "department_name", nullable = false, length = 50)
    private String departmentName;

    @Column(name = "department_description", nullable = true, length = 100)
    private String departmentDescription;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    protected Department() {}

    public Department(String departmentName, String departmentDescription) {
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.createdAt = LocalDateTime.now();
    }
}
