package com.jr.controller.dto;

import com.jr.model.*;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;

public class CreateTaskDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private String solution;

    private Task.Status status;

    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Task.Status getStatus() {
        return status;
    }

    public void setStatus(Task.Status status) {
        this.status = status;
    }
    
    public Set<User> getUsers() {
        return users;
    }

    public void setRoles(Set<User> users) {
        this.users = users;
    }
}