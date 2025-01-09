package com.project.FocusFlow.dto;

import com.project.FocusFlow.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SignUpRequest {
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "password cannot be blank")
    private String password;

    @NotBlank(message = "username cannot be blank")
    @Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters")
    private String username;

    @NotBlank(message = "telegram link cannot be blank")
    private String telegramLink;

    private String profilePicture;

    @NotBlank(message = "status cannot be blank")
    private String status;

    @NotBlank(message = "number of violations cannot be blank")
    private int numberOfViolations;

    @NotBlank(message = "role cannot be blank")
    private Role role;
}
