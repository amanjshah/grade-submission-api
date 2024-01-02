package com.practise.gradesubmission.repository;

import com.practise.gradesubmission.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}