package com.project.FocusFlow.database.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table("users")
public class User extends Person {
    @Id
    private Integer id;

    @Column("status")
    private String status;

    @Column("number_of_violations")
    private int numberOfViolations;

    User(){}

    public User(String email, String password, String username, String role, String telegramName, String profilePicture,String status, int numberOfViolations) {
        super(email, password, username, role, telegramName, profilePicture);
        this.status = status;
        this.numberOfViolations = numberOfViolations;
    }

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", numberOfViolations=" + numberOfViolations + '\'' +
                super.toString();
    }
}
