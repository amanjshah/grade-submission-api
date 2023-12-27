package com.practise.gradesubmission.repository;

import com.practise.gradesubmission.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}