package com.practise.gradesubmission;

import java.time.LocalDate;
import java.util.Arrays;

import com.practise.gradesubmission.entity.Course;
import com.practise.gradesubmission.entity.Student;
import com.practise.gradesubmission.repository.CourseRepository;
import com.practise.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class GradeSubmissionApplication implements CommandLineRunner {

	StudentRepository studentRepository;
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}

	@Override
	public void run(String... args) {
		studentRepository.saveAll(Arrays.asList(
			new Student("Harry Potter", LocalDate.parse(("1980-07-31"))),
            new Student("Ron Weasley", LocalDate.parse(("1980-03-01"))),
            new Student("Hermione Granger", LocalDate.parse(("1979-09-19"))),
            new Student("Neville Longbottom", LocalDate.parse(("1980-07-30")))
		));
		courseRepository.saveAll(Arrays.asList(
			new Course("Charms", "CH104", "Learn spells concerned with giving an object new and unexpected properties."),
			new Course("Defence Against the Dark Arts", "DADA", "Learn defensive techniques against the dark arts."),
			new Course("Herbology", "HB311", "Learn the study of magical plants and how to take care of, utilise and combat them."),
			new Course("History of Magic", "HIS393", "Learn about significant events in wizarding history."),
			new Course("Potions", "POT102", "Learn correct mixing and stirring of ingredients to create mixtures with magical effects."),
			new Course("Transfiguration", "TR442", "Learn the art of changing the form or appearance of an object.")
		));
	}
}
