package com.practise.gradesubmission.service;

import java.util.Collection;
import com.practise.gradesubmission.entity.Course;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    Collection<Course> getCourses();
}