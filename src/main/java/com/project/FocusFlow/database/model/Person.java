package com.project.FocusFlow.database.model;


import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
public abstract class Person{
    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("username")
    private String username;

    @Column("role")
    private String role;

    @Column("telegram_name")
    private String telegramName;

    @Column("profile_picture")
    private String profilePicture;

    @Column("last_activity")
    protected LocalDateTime lastActivity;

    @Column("created_at")
    protected LocalDateTime createdAt;

    public Person(){
    }

    public Person(String email, String password, String username, String role, String telegramName, String profilePicture) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
        this.telegramName = telegramName;
        this.profilePicture = profilePicture;
        this.lastActivity = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return  ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", telegramName='" + telegramName + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", lastActivity=" + lastActivity +
                ", createdAt=" + createdAt +
                '}';
    }
}
