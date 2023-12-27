package com.practise.gradesubmission.service;

import java.util.Collection;
import com.practise.gradesubmission.entity.Grade;

public interface GradeService {
    Grade getGrade(Long studentId, Long courseId);
    Grade saveGrade(Grade grade, Long studentId, Long courseId);
    Grade updateGrade(String score, Long studentId, Long courseId);
    void deleteGrade(Long studentId, Long courseId);
    Collection<Grade> getStudentGrades(Long studentId);
    Collection<Grade> getCourseGrades(Long courseId);
    Collection<Grade> getAllGrades();
}
