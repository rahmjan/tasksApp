package com.jr.service;

import com.jr.model.User;

import java.util.Set;

import com.jr.controller.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    Set<User> getAllUsers();

    User save(UserRegistrationDto registration);
}