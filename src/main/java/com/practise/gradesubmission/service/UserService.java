package com.practise.gradesubmission.service;

import com.practise.gradesubmission.entity.User;

public interface UserService {
    User getUser(Long id);

    User getUser(String username);

    User saveUser(User user);
}