package com.project.FocusFlow.controller;

import com.project.FocusFlow.model.User;
import com.project.FocusFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
    @RequestMapping("/secured")
public class MainController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getBasicInfo")
    public String getInfoAboutYourself(Principal principal) {
        if (principal != null) {
            return "Вы авторизованы!";
        }

        return "Вы не вошли в систему!";
    }

    @GetMapping("/get/user")
    public Principal getInfo(Principal principal) {
        return principal;
    }

    @GetMapping("/get/allUsers")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userService.getUsers();
        return ResponseEntity.ok(userList);
    }
}
