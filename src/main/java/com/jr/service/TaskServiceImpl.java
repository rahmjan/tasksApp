package com.jr.service;

import com.jr.model.Task;
import com.jr.repository.TaskRepository;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jr.controller.dto.taskDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @PersistenceContext
    private EntityManager entityMgr;

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
        
        Boolean refresh = true;
        Task task = findByName(newTask.getName());

        if (task == null) {
            task = new Task();
            refresh = false;
        }

        task.setName(newTask.getName());
        task.setDescription(newTask.getDescription());
        task.setSolution(newTask.getSolution());
        task.setStatus(newTask.getStatus());
        task.setUsers(newTask.getUsers());

        task = taskRepository.save(task);
        // taskRepository.persist(task);

        if (refresh) {
            taskRepository.refresh(task);
        }
        else {
            //taskRepository.persist(task);
        }

        return task;
    }
}