package com.project.FocusFlow.database.models;

import lombok.Data;

import java.util.Date;

@Data
public class Task extends Action{
    private int id;
    private String description;
    private int priority;
    private Date dueData;
    private String status;
}
