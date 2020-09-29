package com.jr.service;

import com.jr.model.Task;
import com.jr.repository.TaskRepository;

import java.util.Set;
import java.util.stream.Collectors;

import com.jr.controller.dto.taskDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task findByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    public Set<Task> getAllTasks() {
        return taskRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Transactional
    public Task save(taskDto newTask) {
        
        Boolean save = false;
        Task task = findByName(newTask.getPrevName());

        if (task == null) {
            task = new Task();
            save = true;
        }

        task.setName(newTask.getName());
        task.setDescription(newTask.getDescription());
        task.setSolution(newTask.getSolution());
        task.setStatus(newTask.getStatus());
        task.setUsers(newTask.getUsers());

        if (save) {
            task = taskRepository.save(task);
        }
        return task;
    }

    @Override
    public Boolean deleteByName(String name) {
        if (taskRepository.deleteByName(name) > 0) {
            return true;
        }
        return false;
    }
}