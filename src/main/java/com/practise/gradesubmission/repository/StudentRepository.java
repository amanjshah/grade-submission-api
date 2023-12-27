package com.practise.gradesubmission.repository;

import com.practise.gradesubmission.entity.Student;
import org.springframework.data.repository.CrudRepository;

// To set up JPA, set up interface extending CrudRepository<{entity}, {id type}>
// At runtime, due to spring-boot-starter-data-jpa dependency, an implementation class is automatically generated
// @Repository annotation will automatically be present on implementation class
// Bean is thus generated, so StudentRepository objects can be autowired
public interface StudentRepository extends CrudRepository<Student, Long> {
}