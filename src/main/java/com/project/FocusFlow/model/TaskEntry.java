package com.project.FocusFlow.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("task_entries")
public class TaskEntry {
    private LocalDateTime scheduledDate;
    private boolean isCompleted;

    @Column("task_id")
    private Task task;

    public TaskEntry(boolean isCompleted) {
        this.scheduledDate = LocalDateTime.now();
        this.isCompleted = isCompleted;
    }
}
