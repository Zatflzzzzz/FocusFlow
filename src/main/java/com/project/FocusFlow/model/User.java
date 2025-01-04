package com.project.FocusFlow.model;

import com.project.FocusFlow.enums.Language;
import com.project.FocusFlow.enums.Themes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table("user")
public class User extends Person {
    @Id
    private Integer id;
    private String status;
    private int numberOfViolations;
    private String role; // ROLE_ADMIN & ROLE_USER

    @MappedCollection(idColumn = "user_id")
    private Settings settings;

    public User(String email, String password, String username, String role, String telegramLink,
                String profilePicture, String status, int numberOfViolations) {

        super(email, password, username, telegramLink, profilePicture);
        this.status = status;
        this.numberOfViolations = numberOfViolations;
        this.role = role;
        this.settings = new Settings(false, Themes.DARK, Language.RU);
    }
}