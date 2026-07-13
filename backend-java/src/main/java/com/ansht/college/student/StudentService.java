package com.ansht.college.student;

import com.ansht.college.common.exception.BusinessRuleException;
import com.ansht.college.common.exception.ResourceNotFoundException;
import com.ansht.college.department.Department;
import com.ansht.college.department.DepartmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public Page<StudentResponse> search(String query, Integer semester, Pageable pageable) {
        String normalized = query == null || query.isBlank() ? null : query.trim();
        return studentRepository.search(normalized, semester, pageable).map(StudentResponse::from);
    }

    @Transactional
    public StudentResponse create(StudentRequest request) {
        ensureUnique(request.rollNumber(), request.email());
        Department department = departmentRepository.findByCodeIgnoreCaseAndDeletedFalse(request.departmentCode())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        Student student = new Student(request.rollNumber(), request.fullName(), request.email(), request.semester(), department);
        return StudentResponse.from(studentRepository.save(student));
    }

    @Transactional
    public StudentResponse update(Long id, StudentRequest request) {
        Student student = findActive(id);
        Department department = departmentRepository.findByCodeIgnoreCaseAndDeletedFalse(request.departmentCode())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        student.update(request.fullName(), request.email(), request.semester(), department);
        return StudentResponse.from(student);
    }

    @Transactional
    public void softDelete(Long id) {
        findActive(id).markDeleted();
    }

    private Student findActive(Long id) {
        return studentRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    private void ensureUnique(String rollNumber, String email) {
        if (studentRepository.existsByRollNumberIgnoreCaseAndDeletedFalse(rollNumber)) {
            throw new BusinessRuleException("Roll number already exists");
        }
        if (studentRepository.existsByEmailIgnoreCaseAndDeletedFalse(email)) {
            throw new BusinessRuleException("Email already exists");
        }
    }
}
