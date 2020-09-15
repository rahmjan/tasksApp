package com.jr.repository;

import com.jr.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CustomRepository<Task, Long> {

    Task findByName(String name);

}