package com.practise.gradesubmission.repository;

import java.util.Collection;
import java.util.Optional;

import com.practise.gradesubmission.entity.Grade;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {

    // to generate additional methods just specify the method name in correct format, as below
    Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);
    @Transactional
    void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
    Collection<Grade> findByStudentId(Long studentId);
    Collection<Grade> findByCourseId(Long courseId);
}