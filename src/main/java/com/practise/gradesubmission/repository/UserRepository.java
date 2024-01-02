package com.practise.gradesubmission.repository;

import java.util.Optional;

import com.practise.gradesubmission.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
}