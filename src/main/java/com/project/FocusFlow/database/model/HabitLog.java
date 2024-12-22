package com.project.FocusFlow.database.model;

import lombok.Data;

import java.sql.Date;

@Data
public class HabitLog {
    private int id;
    private int habitId;
    private Date logDate;
    private String status;
}
