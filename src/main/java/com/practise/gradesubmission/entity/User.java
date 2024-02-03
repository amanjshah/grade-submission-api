package com.practise.gradesubmission.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
// 'user' is a reserved keyword in SQL, so table name is users to avoid org.h2.jdbc.JdbcSQLSyntaxErrorException.
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message =  "username cannot be blank")
	@NonNull
	@Column(nullable = false, unique = true)
	private String username;

	@NotBlank(message =  "password cannot be blank")
    @NonNull
	@Column(nullable = false)
	private String password;

}