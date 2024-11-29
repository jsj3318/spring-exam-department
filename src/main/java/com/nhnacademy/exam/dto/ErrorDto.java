package com.nhnacademy.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorDto {
    private String title;
    private int status;
    private LocalDateTime timestamp;
}
