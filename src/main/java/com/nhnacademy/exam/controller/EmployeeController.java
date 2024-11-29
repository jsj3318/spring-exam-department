package com.nhnacademy.exam.controller;

import com.nhnacademy.exam.dto.employee.EmployeeDto;
import com.nhnacademy.exam.entity.Employee;
import com.nhnacademy.exam.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(
            @PathVariable("id") String id
    ) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return new EmployeeDto(employee.getEmployeeId(), employee.getEmployeeName());
    }
}
