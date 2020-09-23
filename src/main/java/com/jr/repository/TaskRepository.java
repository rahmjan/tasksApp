package com.jr.repository;

import com.jr.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends CustomRepository<Task, Long> {

    Task findByName(String name);

    @Transactional
    Long deleteByName(String name);
}