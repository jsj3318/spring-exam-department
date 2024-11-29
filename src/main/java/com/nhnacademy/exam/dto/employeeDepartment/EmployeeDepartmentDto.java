package com.nhnacademy.exam.dto.employeeDepartment;

import com.nhnacademy.exam.dto.department.DepartmentDto;
import com.nhnacademy.exam.dto.employee.EmployeeDto;
import jakarta.validation.constraints.NotNull;

public record EmployeeDepartmentDto(
        @NotNull DepartmentDto department,
        @NotNull EmployeeDto employee
        ) {
}
