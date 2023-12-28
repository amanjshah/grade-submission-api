package com.practise.gradesubmission.service;

import java.util.Collection;
import java.util.Collections;
import com.practise.gradesubmission.entity.Grade;
import com.practise.gradesubmission.repository.GradeRepository;
import com.practise.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {

    //No need for field injection (@Autowired) due to @AllArgsConstructor
    GradeRepository gradeRepository;
    StudentRepository studentRepository;
    
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        grade.setStudent(studentRepository.findById(studentId).get());
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
