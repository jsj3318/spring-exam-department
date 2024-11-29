package com.nhnacademy.exam.dto.department;

import jakarta.validation.constraints.NotBlank;

public record DepartmentDto(
        @NotBlank String id,
        @NotBlank String name
) {
}
