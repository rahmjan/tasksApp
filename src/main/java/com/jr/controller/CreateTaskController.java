package com.jr.controller;

import com.jr.model.Task;
import com.jr.model.User;
import com.jr.service.TaskService;
import com.jr.service.UserService;
import com.jr.controller.dto.CreateTaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/createTask")
public class CreateTaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @ModelAttribute("task")
    public CreateTaskDto createTaskDto() {
        return new CreateTaskDto();
    }

    @ModelAttribute("allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    public String showCreateTaskForm(Model model) {
        return "createTask";
    }

    @PostMapping
    public String createTask(@ModelAttribute("task") @Valid CreateTaskDto taskDto, BindingResult result){

        Task existing = taskService.findByName(taskDto.getName());
        if (existing != null){
            result.rejectValue("name", null, "There is already an task with the same name");
        }

        if (result.hasErrors()){
            return "createTask";
        }

        taskService.save(taskDto);
        return "redirect:/createTask?success";
    }

}