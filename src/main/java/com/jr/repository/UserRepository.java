package com.jr.repository;

import com.jr.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CustomRepository<User, Long> {

    User findByEmail(String email);

}