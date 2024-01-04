package com.practise.gradesubmission.service;

import java.util.Collection;
import java.util.Set;

import com.practise.gradesubmission.entity.Course;
import com.practise.gradesubmission.entity.Student;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    Collection<Course> getCourses();
    Course addStudentToCourse(Long studentId, Long courseId);
    Set<Student> getEnrolledStudents(Long id);
}