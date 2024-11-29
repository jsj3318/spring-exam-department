package com.nhnacademy.exam.dto.department;

import jakarta.validation.constraints.NotBlank;

public record DepartmentModify(
        @NotBlank String name
) {
}
