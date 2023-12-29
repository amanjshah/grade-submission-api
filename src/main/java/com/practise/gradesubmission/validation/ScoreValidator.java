package com.practise.gradesubmission.validation;

import java.util.Arrays;
import java.util.HashSet;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ScoreValidator implements ConstraintValidator<Score, String> {
    
    HashSet<String> scores = new HashSet<>(Arrays.asList(
        "A+", "A", "A-",
        "B+", "B", "B-",
        "C+", "C", "C-",
        "D+", "D", "D-",
        "F"
    ));
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return scores.contains(value);
    }

}