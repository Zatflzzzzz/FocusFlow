package com.project.FocusFlow.database.model;

import lombok.Data;

@Data
public class Settings {
    private String id;
    private int userId;
    private Boolean notification;
    private String theme;
    private String language;
}
