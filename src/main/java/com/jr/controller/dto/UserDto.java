package com.jr.controller.dto;

import com.jr.model.User;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    @NotEmpty
    private String email;

    @Email
    private String prevEmail;

    public UserDto(){};

    public UserDto(User u) {
        setFirstName(u.getFirstName());
        setLastName(u.getLastName());
        setEmail(u.getEmail());
        setPrevEmail(u.getEmail());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrevEmail() {
        return prevEmail;
    }

    public void setPrevEmail(String email) {
        this.prevEmail = email;
    }
}