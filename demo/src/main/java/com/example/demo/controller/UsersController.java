package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping()
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/registration")
//    public String registrationPage(@ModelAttribute("user") User user) {
//        return "/registration";
//    }
//
//    @PostMapping("/registration")
//    public String performRegistration(@ModelAttribute("user") User user)
//    {
//        Role role = new Role("ROLE_USER");
//        roleService.saveRole(role);
//        user.setRoles(Set.of(role));
//        userService.saveUser(user);
//        return "redirect:/login";
//    }

    @GetMapping("/user")
    public User getUserPage(Model model, Principal principal) {
        Long id = userService.getUserByUsername(principal.getName()).getId();
//        model.addAttribute("user", userService.getUserById(id));
        return userService.getUserById(id);
    }
}
