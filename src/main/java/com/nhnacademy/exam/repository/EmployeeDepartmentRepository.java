package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.entity.EmployeeDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, Long> {
    public List<EmployeeDepartment> findAllByDepartmentDepartmentCode(String departmentCode);
}
