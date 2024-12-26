package com.project.FocusFlow.database.model;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public abstract class Action {
    private int id;
    private String title;
    private String timeToComplete;
    private LocalDateTime created_at;

    Action(){}

    public Action(String title, String timeToComplete) {
        this.title = title;
        this.timeToComplete = timeToComplete;
        created_at = LocalDateTime.now();
    }
}
