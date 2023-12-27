package com.practise.gradesubmission.service;

import java.util.Collection;
import com.practise.gradesubmission.entity.Student;
import com.practise.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This is what needs to be autowired, so @Service annotation goes here rather than on the base interface
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
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


}