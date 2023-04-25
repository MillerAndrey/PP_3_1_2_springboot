package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(@NotNull Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/saveUser")
    public ModelAndView saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return new ModelAndView("redirect:/users");
    }

    @PatchMapping("/updateInfo")
    public String updateUser(@RequestParam(value = "userId") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-create";
    }

    @PatchMapping("/updateUser")
    public ModelAndView update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return new ModelAndView("redirect:/users");
    }


    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam(value = "userId") Long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }
}
