package com.jr.controller.dto;

import com.jr.model.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class taskDto {

    @NotEmpty
    private String name;

    private String prevName;

    @NotEmpty
    private String description;

    private String solution;

    private MultipartFile picture;

    private Task.Status status;

    private Set<User> users;

    public taskDto() {};

    public taskDto(Task t) {
        setName(t.getName());
        setPrevName(t.getName());
        setDescription(t.getDescription());
        setSolution(t.getSolution());
        setStatus(t.getStatus());
        setUsers(t.getUsers());
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrevName() {
        return prevName;
    }

    public void setPrevName(String name) {
        this.prevName = name;
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

    public MultipartFile getPicture() {
        return this.picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    };

    public Task.Status getStatus() {
        return status;
    }

    public void setStatus(Task.Status status) {
        this.status = status;
    }
    
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}