package com.ansht.college.student;

import java.util.UUID;

public record StudentResponse(
        UUID publicId,
        Long id,
        String rollNumber,
        String fullName,
        String email,
        Integer semester,
        String departmentCode,
        String departmentName
) {
    static StudentResponse from(Student student) {
        return new StudentResponse(
                student.getPublicId(),
                student.getId(),
                student.getRollNumber(),
                student.getFullName(),
                student.getEmail(),
                student.getSemester(),
                student.getDepartment().getCode(),
                student.getDepartment().getName()
        );
    }
}
