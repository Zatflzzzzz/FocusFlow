package com.project.FocusFlow.database.model;

import lombok.Data;

import java.sql.Date;

@Data
public abstract class Action {
    private int id;
    private String title;
    private String timeToComplete;
    private Date created_at;
}
