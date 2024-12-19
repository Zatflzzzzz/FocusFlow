package com.project.FocusFlow.database.models;

import lombok.Data;

@Data
public class User extends Person {
    private int id;
    private String status;
    private int numberOfViolations;
}
