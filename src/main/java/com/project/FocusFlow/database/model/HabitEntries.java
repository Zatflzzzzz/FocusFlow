package com.project.FocusFlow.database.model;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Table("habits_entries")
public class HabitEntries {
    private LocalDateTime scheduledDate;
    private boolean isCompleted;

    @Column("habit_id")
    private Habit habit;

    public HabitEntries(boolean isCompleted) {
        this.scheduledDate = LocalDateTime.now();
        this.isCompleted = isCompleted;
    }
}
