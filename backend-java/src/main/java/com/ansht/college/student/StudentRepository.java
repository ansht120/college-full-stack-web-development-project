package com.ansht.college.student;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @EntityGraph(attributePaths = "department")
    @Query("""
            select s from Student s
            where s.deleted = false
              and (:search is null or lower(s.fullName) like lower(concat('%', :search, '%'))
                   or lower(s.rollNumber) like lower(concat('%', :search, '%'))
                   or lower(s.email) like lower(concat('%', :search, '%')))
              and (:semester is null or s.semester = :semester)
            """)
    Page<Student> search(@Param("search") String search, @Param("semester") Integer semester, Pageable pageable);

    Optional<Student> findByIdAndDeletedFalse(Long id);

    boolean existsByRollNumberIgnoreCaseAndDeletedFalse(String rollNumber);

    boolean existsByEmailIgnoreCaseAndDeletedFalse(String email);
}
