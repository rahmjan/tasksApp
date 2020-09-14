package com.jr.service;

import com.jr.model.Task;
import com.jr.controller.dto.taskDto;

public interface TaskService {

    Task findByName(String name);

    Task save(taskDto newTask);
}