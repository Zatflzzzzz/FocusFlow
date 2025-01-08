package com.project.FocusFlow.model;

import com.project.FocusFlow.model.enums.Priority;
import com.project.FocusFlow.model.enums.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Table("task")
public class Task extends Action{
    @Id
    private int id;
    private LocalDateTime deadline;
    private Category category;
    private Priority priority;
    private boolean isCompleted;

    @Column("user_id")
    AggregateReference<User, Integer> user;

    @MappedCollection(idColumn = "task_id")
    private Set<TaskEntry> entries = new HashSet<>();

    public Task(String title, Date dueDate, String description,
                Priority priority, Category category, boolean isCompleted,
                AggregateReference<User, Integer> user) {

        super(title, dueDate, description);
        this.priority = priority;
        this.isCompleted = isCompleted;
        this.category = category;
        this.user = user;
    }

    public void addEntry(TaskEntry entry){
        entries.add(entry);
    }
}
