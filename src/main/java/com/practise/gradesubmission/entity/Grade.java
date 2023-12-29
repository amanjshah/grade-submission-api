package com.practise.gradesubmission.entity;

import com.practise.gradesubmission.validation.Score;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"}))
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Score
    @Column(nullable = false)
    private String score;

    // To create foreign key column, specify: type, referenced primary key column, chosen name
    // Grade must belong to a student, so student field should always be present - optional = False
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;

    // Since the constraint is that you can't have multiple grades for same studentId/courseId pair...
    // Constraint has to be specified using @UniqueConstraint inside @Table
    // If constraint was one grade per student, can be implemented using unique = true inside @Column/@JoinColumn
}
