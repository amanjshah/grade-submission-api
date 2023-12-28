package com.practise.gradesubmission.service;

import java.util.Collection;
import java.util.Optional;

import com.practise.gradesubmission.entity.Course;
import com.practise.gradesubmission.exception.CourseNotFoundException;
import com.practise.gradesubmission.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

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

    static Course unwrapCourse(Optional<Course> course, Long id){
        if (course.isPresent()) return course.get();
        throw new CourseNotFoundException(id);
    }
}
