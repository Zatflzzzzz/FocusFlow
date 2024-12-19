package com.project.FocusFlow.database.models;

import lombok.Data;

@Data
public class Settings {
    private int id;
    private int userId;
    private Boolean notification;
    private String theme;
    private String language;
}
