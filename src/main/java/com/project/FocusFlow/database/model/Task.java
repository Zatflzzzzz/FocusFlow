package com.project.FocusFlow.database.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Task extends Action{
    private int id;
    private int priority;
    private Date dueData;
    private String status;
}
