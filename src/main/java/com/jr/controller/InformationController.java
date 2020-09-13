package com.jr.controller;

import com.jr.service.TaskService;
import com.jr.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InformationController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @RequestMapping("/myTasks")
    @GetMapping
    public String showMyTaskForm(Model model) {
        model.addAttribute("currentUser", userService.getCurrentUser());
        model.addAttribute("currentUserTasks", userService.getCurrentUser().getTasks());
        return "myTasks";
    }
}
