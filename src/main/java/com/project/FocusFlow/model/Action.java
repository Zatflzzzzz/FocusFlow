package com.project.FocusFlow.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.sql.Date;

@Data
public abstract class Action {
    private String title;
    private String description;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    Action(){}

    public Action(String title, Date dueDate, String description) {
        this.title = title;
        this.description = description;
        this.updatedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Action{" +
                "Title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", updatedDate=" + updatedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
