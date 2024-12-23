package com.project.FocusFlow.database.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
public abstract class Action {
    @Id
    private int id;
    private String title;
    private String timeToComplete;
    private Date created_at;
}
