package com.practise.gradesubmission.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private Long id;
    private String name;
    private LocalDate birthDate;

}
