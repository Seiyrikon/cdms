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
    private Long department_id;

    @Column(name = "department_name", nullable = false, length = 100)
    private String department_name;

    @Column(name = "department_description", nullable = true, length = 100)
    private String department_description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    protected Department() {}

    public Department(String department_name, String department_description) {
        this.department_name = department_name;
        this.department_description = department_description;
        this.created_at = LocalDateTime.now();
    }
}
