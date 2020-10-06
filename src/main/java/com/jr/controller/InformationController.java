package com.jr.controller;

import com.jr.model.Task;
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
    public String showTasksForm(@RequestParam(required = false, defaultValue = "me") String user, Model model) {

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
            model.addAttribute("title", u.getFirstName() + " " + u.getLastName() + "'s tasks");
            model.addAttribute("iterTasks", u.getTasks());
        }
        
        return "showTasks";
    }

    @RequestMapping("/showUsers")
    @GetMapping
    public String showUsersForm(@RequestParam(required = false, defaultValue = "all") String task, Model model) {

        if (task.equals("all")) {
            model.addAttribute("title", "All users in the database");
            model.addAttribute("iterUsers", userService.getAllUsers());
        }
        else {
            Task t = taskService.findByName(task);
            model.addAttribute("title", t.getName() + "'s users");
            model.addAttribute("iterUsers", t.getUsers());
        }
        
        return "showUsers";
    }
}
