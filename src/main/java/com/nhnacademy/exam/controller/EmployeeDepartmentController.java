package com.nhnacademy.exam.controller;

import com.nhnacademy.exam.dto.department.DepartmentDto;
import com.nhnacademy.exam.dto.employee.EmployeeDto;
import com.nhnacademy.exam.dto.employeeDepartment.EmployeeDepartmentDto;
import com.nhnacademy.exam.entity.EmployeeDepartment;
import com.nhnacademy.exam.repository.EmployeeDepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department-members")
@RequiredArgsConstructor
public class EmployeeDepartmentController {

    private final EmployeeDepartmentRepository employeeDepartmentRepository;

    @GetMapping
    public List<EmployeeDepartmentDto> getAll(
            @RequestParam(value = "departmentIds", required = false) List<String> departmentIds
            ){
        // 파라미터가 있는지 검사
        if(departmentIds == null || departmentIds.isEmpty()){
            throw new IllegalArgumentException("Required request parameter 'departmentIds' for method parameter");
        }

        // url 파라미터로 넘어온 모든 부서 아이디들의 관계 엔티티들 반환해야 함
        List<EmployeeDepartmentDto> dtoList = new ArrayList<>();

        // 모든 부서의
        for(String departmentId : departmentIds) {
            List<EmployeeDepartment> edList = employeeDepartmentRepository.findAllByDepartmentDepartmentCode(departmentId);
            // 모든 관계
            for(EmployeeDepartment ed : edList) {
                //dto로 저장
                dtoList.add(new EmployeeDepartmentDto(
                        new DepartmentDto(ed.getDepartment().getDepartmentCode(), ed.getDepartment().getDepartmentName()),
                        new EmployeeDto(ed.getEmployee().getEmployeeId(), ed.getEmployee().getEmployeeName())
                ));
            }
        }

        return dtoList;
    }



}
