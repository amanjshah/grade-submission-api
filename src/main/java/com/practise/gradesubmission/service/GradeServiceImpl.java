package com.practise.gradesubmission.service;

import java.util.Collection;
import java.util.Optional;

import com.practise.gradesubmission.entity.Course;
import com.practise.gradesubmission.entity.Grade;
import com.practise.gradesubmission.entity.Student;
import com.practise.gradesubmission.exception.GradeNotFoundException;
import com.practise.gradesubmission.exception.StudentNotEnrolledException;
import com.practise.gradesubmission.repository.CourseRepository;
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
    CourseRepository courseRepository;
    
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return unwrapGrade(gradeRepository.findByStudentIdAndCourseId(studentId, courseId), studentId, courseId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId);
        Course course = CourseServiceImpl.unwrapCourse(courseRepository.findById(courseId), courseId);
        if (!student.getCourses().contains(course)) throw new StudentNotEnrolledException(studentId, courseId);
        grade.setStudent(StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId));
        grade.setCourse(CourseServiceImpl.unwrapCourse(courseRepository.findById(courseId), courseId));
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Grade grade = unwrapGrade(gradeRepository.findByStudentIdAndCourseId(studentId, courseId), studentId, courseId);
        grade.setScore(score);
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public Collection<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public Collection<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public Collection<Grade> getAllGrades() {
        return (Collection<Grade>) gradeRepository.findAll();
    }

    static Grade unwrapGrade(Optional<Grade> grade, Long studentId, Long courseId){
        if (grade.isPresent()) return grade.get();
        throw new GradeNotFoundException(studentId, courseId);
    }

}
