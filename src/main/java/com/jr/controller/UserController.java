package com.jr.controller;

import com.jr.model.User;
import com.jr.service.UserService;
import com.jr.controller.dto.UserDto;
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

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUserForm(@RequestParam(required = true) String email, Model model) {

        User u = userService.findByEmail(email);
        
        model.addAttribute("title", "User details");
        model.addAttribute("userDto", new UserDto(u));
        model.addAttribute("actionAtt", "/user");
        model.addAttribute("allRoles", userService.getAllRoles());

        return "user";
    }

    @PostMapping
    public String updateUser(@ModelAttribute("userDto") @Valid UserDto userDto, 
                              BindingResult result){

        if (result.hasErrors()){
            return "redirect:/user?email=" + userDto.getEmail();
        }

        userService.update(userDto);

        return "redirect:/user?email=" + userDto.getEmail() + "&success";
    }

    @DeleteMapping
    public String deleteUser(@RequestParam(required = true) String email, @ModelAttribute("userDto") UserDto userDto, BindingResult result) {
        
        if (!userService.deleteByEmail(email)){
            result.rejectValue("name", null, "There is NOT a user with this email");
        }

        if (result.hasErrors()){
            return "user";
        }

        return "showTasks";
    }

}