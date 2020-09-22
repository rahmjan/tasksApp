package com.jr.controller;

import com.jr.model.User;
import com.jr.service.TaskService;
import com.jr.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InformationController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @RequestMapping("/showTasks")
    @GetMapping
    public String showMyTaskForm(@RequestParam(required = false, defaultValue = "me") String user, Model model) {

        if (user.equals("me")) {
            model.addAttribute("title", "My tasks");
            model.addAttribute("iterTasks", userService.getCurrentUser().getTasks());
        }
        else if (user.equals("all")) {
            model.addAttribute("title", "All tasks in the database");
            model.addAttribute("iterTasks", taskService.getAllTasks());
        }
        else {
            User u = userService.findByEmail(user);
            model.addAttribute("title", u.getFirstName() + " " + u.getLastName() + "'s tasks'");
            model.addAttribute("iterTasks", u.getTasks());
        }
        
        return "showTasks";
    }
}
