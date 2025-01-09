package com.project.FocusFlow.model;

import com.project.FocusFlow.model.enums.Language;
import com.project.FocusFlow.model.enums.Role;
import com.project.FocusFlow.model.enums.Themes;
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
    private Role role; //"ROLE_USER" или "ROLE_ADMIN"

    @MappedCollection(idColumn = "user_id")
    private Settings settings;

    public User(String email, String password, String username, Role role, String telegramLink,
                String profilePicture, String status, int numberOfViolations) {

        super(email, password, username, telegramLink, profilePicture);
        this.status = status;
        this.numberOfViolations = numberOfViolations;
        this.role = role;
        this.settings = new Settings(false, Themes.DARK, Language.RU);
    }
}