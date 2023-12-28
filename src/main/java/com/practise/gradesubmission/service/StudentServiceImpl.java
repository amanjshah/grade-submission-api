package com.practise.gradesubmission.service;

import java.util.Collection;
import java.util.Optional;

import com.practise.gradesubmission.entity.Student;
import com.practise.gradesubmission.exception.StudentNotFoundException;
import com.practise.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//Require a bean of the impl class, so @Service goes here rather than base interface
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return unwrapStudent(studentRepository.findById(id), id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Collection<Student> getStudents() {
        return (Collection<Student>) studentRepository.findAll();
    }

    static Student unwrapStudent(Optional<Student> student, Long id){
        if (student.isPresent()) return student.get();
        throw new StudentNotFoundException(id);
    }
}