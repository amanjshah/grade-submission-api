package com.practise.gradesubmission;

import java.util.List;

import com.practise.gradesubmission.exception.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
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


}
