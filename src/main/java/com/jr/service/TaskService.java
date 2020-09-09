package com.jr.service;

import com.jr.model.Task;
import com.jr.controller.dto.CreateTaskDto;

public interface TaskService {

    Task findByName(String name);

    Task save(CreateTaskDto newTask);
}