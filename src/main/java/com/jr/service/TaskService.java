package com.jr.service;

import com.jr.model.Task;

import java.util.Set;

import com.jr.controller.dto.taskDto;

public interface TaskService {

    Task findByName(String name);

    Set<Task> getAllTasks();

    Task save(taskDto newTask);
}