package com.example.homew10.controllers;

import com.example.homew10.entities.User;
import com.example.homew10.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = (List<User>) userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/addUser")
    public String addUserView(Model model) {
        return "addUser";
    }

    @Transactional
    @PostMapping("/users")
    public String addUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userService.saveUser(user);
        return "redirect:/users";
    }

}