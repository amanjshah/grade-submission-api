package com.practise.gradesubmission;

import java.util.List;

import com.practise.gradesubmission.exception.CourseNotFoundException;
import com.practise.gradesubmission.exception.ErrorResponse;
import com.practise.gradesubmission.exception.GradeNotFoundException;
import com.practise.gradesubmission.exception.StudentNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CourseNotFoundException.class, GradeNotFoundException.class, StudentNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex){
        return new ResponseEntity<>(new ErrorResponse(List.of(ex.getMessage())), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleDataAccessException(EmptyResultDataAccessException ex) {
        return new ResponseEntity<>(new ErrorResponse(List.of("Cannot delete non-existing resource")), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return new ResponseEntity<>(new ErrorResponse(List.of("Cannot save multiple grades per course per student")), HttpStatus.BAD_REQUEST);
    }

}
