package com.project.FocusFlow.controller;

import com.project.FocusFlow.model.User;
import com.project.FocusFlow.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/test")
public class TestController {
    private UserService userService;

    @GetMapping("/welcome_all")
    public String welcomeAll() {
        return "Здарова всем";
    }

    @GetMapping("/welcome_user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String welcomeUser() {
        return "Здарова пользователь";
    }

    @GetMapping("/welcome_admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcomeAdmin(){
        return "Здарова админ";
    }

    @PostMapping("/new-user")
    public String createUser(@RequestBody User user) {
        userService.addUser(user);
        return "Новый пользователь создан";
    }
}
