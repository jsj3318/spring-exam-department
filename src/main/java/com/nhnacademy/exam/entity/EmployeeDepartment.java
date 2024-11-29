package com.nhnacademy.exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmployeeDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long edId;

    @ManyToOne
    @JoinColumn(name = "department_code", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public EmployeeDepartment(Department department, Employee employee) {
        this.department = department;
        this.employee = employee;
    }
}
