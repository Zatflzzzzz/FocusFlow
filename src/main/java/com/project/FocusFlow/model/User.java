package com.project.FocusFlow.model;

import com.project.FocusFlow.model.enums.Language;
import com.project.FocusFlow.model.enums.Themes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper=true)
@Data
@Table("user")
public class User extends Person {
    @Id
    private Integer id;
    private String status;
    private int numberOfViolations;
    private int accessLevel;

    @MappedCollection(idColumn = "user_id")
        private Settings settings = new Settings(false, Themes.DARK, Language.RU);

    public User(String email, String password, String username, String role, String telegramLink,
                String profilePicture, String status, int numberOfViolations, int accessLevel) {

        super(email, password, username, role, telegramLink, profilePicture);
        this.status = status;
        this.numberOfViolations = numberOfViolations;
        this.accessLevel = accessLevel;
    }

    public int getId(){
        return id;
    }
}
