package com.nhnacademy.exam.dto.department;

import jakarta.validation.constraints.NotBlank;

public record DepartmentRegister(
        @NotBlank String id,
        @NotBlank String name
) {
}
