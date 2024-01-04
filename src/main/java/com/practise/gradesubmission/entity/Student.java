package com.practise.gradesubmission.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
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
    @NotBlank(message = "Name cannot be blank")
    @Column(nullable = false)
    private String name;

    @NonNull
    @Past(message = "The birth date must be in the past")
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

    // Both Student and Course are "owning" sides in their many-to-many relationship
    // Sometimes only one entity in the many-to-many relationship should manage the relationship
    // In such cases, the non-owning side does not manage relationship, so should NOT have @JoinTable annotation.
    // Use mappedBy parameter in @ManyToMany to ensure JPA does not manage relationship from this side
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "course_student",
        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private Set<Course> courses;

}
