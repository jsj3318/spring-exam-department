package com.nhnacademy.exam.config;

import com.nhnacademy.exam.dto.DepartmentData;
import com.nhnacademy.exam.entity.Department;
import com.nhnacademy.exam.entity.Employee;
import com.nhnacademy.exam.entity.EmployeeDepartment;
import com.nhnacademy.exam.parser.DepartmentParserResolver;
import com.nhnacademy.exam.repository.DepartmentRepository;
import com.nhnacademy.exam.repository.EmployeeDepartmentRepository;
import com.nhnacademy.exam.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DataInitializer {
    // 애플리케이션 시작 시 데이터 초기화 하기 위한 빈
    private final EmployeeDepartmentRepository employeeDepartmentRepository;
    private final DepartmentParserResolver departmentParserResolver;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void initData() throws IOException {
        // 4개의 데이터 파일 다 가져와버리기
        List<String> pathList = List.of(
                "data/department.json",
                "data/department.csv",
                "data/department-1.txt",
                "data/department-2.txt"
        );

        for(String path : pathList) {
            Resource resource = (Resource) new PathMatchingResourcePatternResolver().getResource("classpath:" + path);

            List<DepartmentData> dataList = departmentParserResolver.getDepartmentParser(path)
                    .parsing(resource.getFile());

            for(DepartmentData data : dataList) {

                //DepartmentData를 관계 엔티티로 변환
                EmployeeDepartment employeeDepartment = new EmployeeDepartment(
                        new Department(data.getDepartmentCode(), data.getDepartmentName()),
                        new Employee(data.getEmployeeId(), data.getEmployeeName())
                );

                // 부서와 사원을 먼저 저장한 후 관계 저장
                departmentRepository.save(employeeDepartment.getDepartment());
                employeeRepository.save(employeeDepartment.getEmployee());
                employeeDepartmentRepository.save(employeeDepartment);

            }

        }


    }

}
