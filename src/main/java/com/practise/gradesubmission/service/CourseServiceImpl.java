package com.practise.gradesubmission.service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import com.practise.gradesubmission.entity.Course;
import com.practise.gradesubmission.entity.Student;
import com.practise.gradesubmission.exception.EntityNotFoundException;
import com.practise.gradesubmission.repository.CourseRepository;
import com.practise.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;
    StudentRepository studentRepository;

    @Override
    public Course getCourse(Long id) {
        return unwrapCourse(courseRepository.findById(id), id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Collection<Course> getCourses() {
        return (Collection<Course>) courseRepository.findAll();
    }

    @Override
    public Course addStudentToCourse(Long studentId, Long courseId) {
        Course course = getCourse(courseId);
        course.getStudents().add(StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId));
        return courseRepository.save(course);
    }

    @Override
    public Set<Student> getEnrolledStudents(Long id) {
        return getCourse(id).getStudents();
    }

    static Course unwrapCourse(Optional<Course> course, Long id){
        if (course.isPresent()) return course.get();
        throw new EntityNotFoundException(id, Course.class);
    }
}
