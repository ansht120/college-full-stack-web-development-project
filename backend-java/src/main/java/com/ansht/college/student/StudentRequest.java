package com.ansht.college.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StudentRequest(
        @NotBlank @Size(max = 40) String rollNumber,
        @NotBlank @Size(max = 120) String fullName,
        @Email @NotBlank @Size(max = 160) String email,
        @NotNull @Min(1) @Max(12) Integer semester,
        @NotBlank @Size(max = 20) String departmentCode
) {
}
