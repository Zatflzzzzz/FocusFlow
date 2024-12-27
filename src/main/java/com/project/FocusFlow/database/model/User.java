package com.project.FocusFlow.database.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper=true)
@Data
@Table("users")
public class User extends Person {
    @Id
    private Integer id;
    private String status;
    private int numberOfViolations;

    public User(String email, String password, String username, String role, String telegramLink, String profilePicture,String status, int numberOfViolations) {
        super(email, password, username, role, telegramLink, profilePicture);
        this.status = status;
        this.numberOfViolations = numberOfViolations;
    }

    public int getId(){
        return id;
    }
}
