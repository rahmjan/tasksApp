package com.jr.service;

import com.jr.model.User;

import java.util.List;

import com.jr.controller.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    List<User> getAllUsers();

    User save(UserRegistrationDto registration);
}