package com.project.FocusFlow.database.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.sql.Date;

@Data
public abstract class Action {
    private String title;
    private Date dueDate;
    private String description;
    private LocalDateTime updatedDate;
    private LocalDateTime created_at;

    Action(){}

    public Action(String title, Date dueDate, String description) {
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.updatedDate = LocalDateTime.now();
        this.created_at = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Action{" +
                "Title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", description='" + description + '\'' +
                ", updatedDate=" + updatedDate +
                ", created_at=" + created_at +
                '}';
    }
}
