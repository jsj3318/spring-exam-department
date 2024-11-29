package com.nhnacademy.exam.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DepartmentData {
    // data 파일에서 받아오는 클래스

    private String employeeId;
    private String employeeName;
    private String departmentName;
    private String departmentCode;

    @JsonCreator
    public DepartmentData(
            @JsonProperty("사번") String employeeNo,
            @JsonProperty("이름") String employeeName,
            @JsonProperty("부서") String departmentName,
            @JsonProperty("부서코드") String departmentCode) {
        this.employeeId = employeeNo;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }
}
