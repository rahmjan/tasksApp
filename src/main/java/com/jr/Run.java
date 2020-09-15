package com.jr;

import com.jr.repository.CustomRepositoryImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories (repositoryBaseClass = CustomRepositoryImpl.class)
public class Run {
    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
}