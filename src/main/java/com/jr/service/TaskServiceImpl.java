package com.jr.service;

import com.jr.model.Task;
import com.jr.repository.TaskRepository;
import com.jr.controller.dto.taskDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task findByName(String name) {
        return taskRepository.findByName(name);
    }

    public Task save(taskDto newTask) {

        Task task = findByName(newTask.getName());
        if (task == null) {
            task = new Task();
        }

        task.setName(newTask.getName());
        task.setDescription(newTask.getDescription());
        task.setSolution(newTask.getSolution());
        task.setStatus(newTask.getStatus());
        task.setUsers(newTask.getUsers());

        return taskRepository.save(task);
    }
}