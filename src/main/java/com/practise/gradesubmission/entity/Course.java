package com.practise.gradesubmission.entity;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Subject cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String subject;

    @NotBlank(message = "Course code cannot be blank")
    @NonNull
    @Column(nullable = false, unique = true)
    private String code;

    @NotBlank(message = "Description cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Collection<Grade> grades;
}
