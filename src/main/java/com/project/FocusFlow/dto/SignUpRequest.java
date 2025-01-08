package com.project.FocusFlow.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SignUpRequest {
    private String email;
    private String password;
    private String username;
    private String telegramLink;
    private String profilePicture;
    private String status;
    private int numberOfViolations;
    private String role;
}
