package com.nhnacademy.exam.dto.employee;

import jakarta.validation.constraints.NotBlank;

public record EmployeeDto(
        @NotBlank String id,
        @NotBlank String name
) {
}
