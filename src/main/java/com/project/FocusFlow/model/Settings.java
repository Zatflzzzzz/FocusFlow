package com.project.FocusFlow.model;

import com.project.FocusFlow.model.enums.Language;
import com.project.FocusFlow.model.enums.Themes;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("settings")
public class Settings {
    private boolean notification;
    private Themes theme;
    private Language language;

    @Column("user_id")
    private User user;

    public Settings(boolean notification, Themes theme, Language language) {
        this.notification = notification;
        this.theme = theme;
        this.language = language;
    }
}