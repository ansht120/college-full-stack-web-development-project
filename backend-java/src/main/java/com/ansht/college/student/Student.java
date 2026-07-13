package com.ansht.college.student;

import com.ansht.college.common.BaseEntity;
import com.ansht.college.department.Department;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 40)
    private String rollNumber;

    @Column(nullable = false, length = 120)
    private String fullName;

    @Column(nullable = false, unique = true, length = 160)
    private String email;

    @Column(nullable = false)
    private Integer semester;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    protected Student() {
    }

    public Student(String rollNumber, String fullName, String email, Integer semester, Department department) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.email = email;
        this.semester = semester;
        this.department = department;
    }

    public void update(String fullName, String email, Integer semester, Department department) {
        this.fullName = fullName;
        this.email = email;
        this.semester = semester;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getSemester() {
        return semester;
    }

    public Department getDepartment() {
        return department;
    }
}
