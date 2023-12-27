package com.practise.gradesubmission.service;

import java.util.Collection;
import java.util.Collections;
import com.practise.gradesubmission.entity.Grade;
import com.practise.gradesubmission.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepository gradeRepository;
    
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return null;
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        return null;
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
    }

    @Override
    public Collection<Grade> getStudentGrades(Long studentId) {
        return Collections.emptyList();
    }

    @Override
    public Collection<Grade> getCourseGrades(Long courseId) {
        return Collections.emptyList();
    }

    @Override
    public Collection<Grade> getAllGrades() {
        return Collections.emptyList();
    }

}
