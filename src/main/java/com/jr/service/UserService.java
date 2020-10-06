package com.jr.service;

import com.jr.model.Role;
import com.jr.model.User;

import java.util.Set;

import com.jr.controller.dto.UserDto;
import com.jr.controller.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User getCurrentUser();

    Set<User> getAllUsers();

    User update(UserDto userDto);

    User save(UserRegistrationDto registration);

    Boolean deleteByEmail(String email);

    Set<Role> getAllRoles();
}