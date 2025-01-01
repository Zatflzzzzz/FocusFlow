package com.project.FocusFlow.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("habit_entries")
public class HabitEntry {
    private LocalDateTime scheduledDate;
    private boolean isCompleted;

    @Column("habit_id")
    private Habit habit;

    public HabitEntry(boolean isCompleted) {
        this.scheduledDate = LocalDateTime.now();
        this.isCompleted = isCompleted;
    }
}
