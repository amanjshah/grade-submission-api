package com.practise.gradesubmission.service;

import com.practise.gradesubmission.entity.User;

public interface UserService {
    User getUser(Long id);
    User saveUser(User user);
}