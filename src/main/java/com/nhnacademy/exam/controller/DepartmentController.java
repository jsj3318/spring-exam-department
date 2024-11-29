package com.nhnacademy.exam.controller;

import com.nhnacademy.exam.dto.department.DepartmentDto;
import com.nhnacademy.exam.dto.department.DepartmentModify;
import com.nhnacademy.exam.dto.department.DepartmentRegister;
import com.nhnacademy.exam.dto.department.DepartmentRegisterResponse;
import com.nhnacademy.exam.entity.Department;
import com.nhnacademy.exam.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentRegisterResponse register(
            @RequestBody DepartmentRegister departmentRegister
            ){
        departmentRepository.save(
                new Department(departmentRegister.id(), departmentRegister.name())
        );
        return new DepartmentRegisterResponse(departmentRegister.id());
    }

    @GetMapping("/{code}")
    public DepartmentDto get(
            @PathVariable("code") Department department
    ){
        return new DepartmentDto(department.getDepartmentCode(), department.getDepartmentName());
    }

    @PutMapping("/{code}")
    public void update(
            @PathVariable("code") String code,
            @RequestBody DepartmentModify departmentModify
            ){
        if(departmentRepository.existsById(code)) {
            departmentRepository.save(new Department(code, departmentModify.name()));
        }
    }

    @DeleteMapping("/{code}")
    public void delete(
            @PathVariable("code") String code
    ){
        departmentRepository.deleteById(code);
    }

}
