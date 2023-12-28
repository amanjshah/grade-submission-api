package com.practise.gradesubmission.repository;

import com.practise.gradesubmission.entity.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    Grade findByStudentId(Long studentId);
}