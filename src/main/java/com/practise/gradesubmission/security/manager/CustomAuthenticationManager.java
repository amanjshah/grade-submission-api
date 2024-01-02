package com.practise.gradesubmission.security.manager;

import com.practise.gradesubmission.entity.User;
import com.practise.gradesubmission.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private UserServiceImpl userServiceImpl;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userServiceImpl.getUser(authentication.getName());
        if (bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())){
            return new UsernamePasswordAuthenticationToken(authentication.getName(), user.getPassword());
        }
        throw new BadCredentialsException("Incorrect password");
    }
}
