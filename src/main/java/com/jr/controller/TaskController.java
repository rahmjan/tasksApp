package com.jr.controller;

import com.jr.model.Task;
import com.jr.model.User;
import com.jr.service.TaskService;
import com.jr.service.UserService;
import com.jr.controller.dto.taskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @ModelAttribute("allUsers")
    public Set<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    public String getTaskForm(@RequestParam(required = false) String name, Model model) {
        Task existing = taskService.findByName(name);

        if (existing != null){
            model.addAttribute("title", "Task details");
            model.addAttribute("taskDto", new taskDto(existing));
            model.addAttribute("actionAtt", "/task");
        }
        else {
            model.addAttribute("title", "Creation of a new task");
            model.addAttribute("taskDto", new taskDto());
            model.addAttribute("actionAtt", "/task?create=true");
        }

        return "task";
    }

    @PostMapping
    public String updateTask(@RequestParam(required = false, defaultValue = "false") Boolean create, 
                             @ModelAttribute("taskDto") @Valid taskDto taskDto, 
                              BindingResult result){
         if (create) {
            Task existing = taskService.findByName(taskDto.getName());
            if (existing != null){
                result.rejectValue("name", null, "There is already an task with the same name");
            }
        }

        if (result.hasErrors()){
            return "task";
        }

        taskService.save(taskDto);
        return "redirect:/task?name=" + taskDto.getName() + "&success";
    }

    @DeleteMapping
    public String deleteTask(@RequestParam(required = true) String name, @ModelAttribute("taskDto") taskDto taskDto, BindingResult result) {
        
        if (!taskService.deleteByName(name)){
            result.rejectValue("name", null, "There is NOT a task with this name");
        }

        if (result.hasErrors()){
            return "task";
        }

        return "redirect:/task?success";
    }

}