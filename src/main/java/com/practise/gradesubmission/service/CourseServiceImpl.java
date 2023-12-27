package com.practise.gradesubmission.service;

import java.util.Collection;
import java.util.Collections;
import com.practise.gradesubmission.entity.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public Course getCourse(Long id) {
        return null;
    }

    @Override
    public Course saveCourse(Course course) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {        
    }

    @Override
    public Collection<Course> getCourses() {
        return Collections.emptyList();
    }

}
