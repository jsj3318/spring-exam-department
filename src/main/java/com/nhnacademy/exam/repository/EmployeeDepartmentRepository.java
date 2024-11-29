package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.entity.EmployeeDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, Long> {
}
