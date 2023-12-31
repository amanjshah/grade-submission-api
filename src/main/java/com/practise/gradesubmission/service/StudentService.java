package com.practise.gradesubmission.service;

import java.util.Collection;
import java.util.Set;

import com.practise.gradesubmission.entity.Course;
import com.practise.gradesubmission.entity.Student;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    Collection<Student> getStudents();
    Set<Course> getEnrolledCourses(Long id);
}