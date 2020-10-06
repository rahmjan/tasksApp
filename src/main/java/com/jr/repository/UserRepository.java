package com.jr.repository;

import javax.transaction.Transactional;

import com.jr.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CustomRepository<User, Long> {

    User findByEmail(String email);

    @Transactional
    Long deleteByEmail(String email);
}