package com.practise.gradesubmission.entity;

import java.time.LocalDate;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NonNull annotated properties will be present in the required args constructor
    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(nullable = false)
    private LocalDate birthDate;

    // mappedBy tells JPA the relationship is already being managed by the owner of the relationship - Grade entity
    // If mappedBy is not specified, spring JPA automatically will create new table STUDENT_GRADES
    // mappedBy value must match the exact name of the Student property in the Grade entity - "student"
    // cascade must be specified so Grade table is altered when student properties are altered
    // e.g. if a student entity is deleted, the grade rows with the corresponding student id must also be deleted.
    // @JsonIgnore ensures a list of JSON grade entities is not generated during JSON serialization process for student
    // Grade's JSON includes a student property for this student, so inf JSON generated if grades are serialised here
    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Collection<Grade> grades;

}
