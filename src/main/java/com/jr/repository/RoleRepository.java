package com.jr.repository;

import com.jr.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CustomRepository<Role, Long> {

    Role findByName(String name);
}