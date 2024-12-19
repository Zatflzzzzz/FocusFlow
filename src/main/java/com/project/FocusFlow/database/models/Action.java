package com.project.FocusFlow.database.models;

import lombok.Data;

import java.sql.Date;

@Data
public class Action {
    private int id;
    private String title;
    private String timeToComplete;
    private Date created_at;
}
