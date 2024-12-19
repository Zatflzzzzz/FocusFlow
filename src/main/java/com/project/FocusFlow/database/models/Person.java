package com.project.FocusFlow.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.security.Timestamp;
import java.util.Date;

public abstract class Person {
    private String email;
    private String password;
    private String username;
    private String role;
    private String telegramName;
    private String profilePicture;
    private Date lastActivity;
    private Timestamp created_at;
}
