package com.project.FocusFlow.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class Person{
    private String email;
    private String password;
    private String username;
    private String telegramLink;
    private String profilePicture;
    private LocalDateTime lastAction;
    private LocalDateTime createdAt;

    Person(){}

    public Person(String email, String password, String username, String telegramLink, String profilePicture) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.telegramLink = telegramLink;
        this.profilePicture = profilePicture;
        this.lastAction = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }
}
