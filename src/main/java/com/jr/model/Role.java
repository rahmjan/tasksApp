package com.jr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

    public enum Type {ROLE_USER, ROLE_MANAGER, ROLE_ADMIN};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(columnDefinition="TEXT")
    private String name;

    public Role() {
    }

    public Role(Type name) {
        this.name = name.toString();
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object anObject) {  
        if (this == anObject) {  
            return true;  
        }  
        if (anObject instanceof Role) {  
            Role anotherUser = (Role) anObject;  
            if (this.id == anotherUser.id)
            {
                return true;
            }
        }  
        return false;  
    } 
}