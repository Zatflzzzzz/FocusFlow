package com.project.FocusFlow.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Table("habit")
public class Habit extends Action{
    @Id
    private Integer id;
    private LocalTime timeToComplete;
    private Date dueDate;

    @Column("user_id")
    private AggregateReference<User, Integer> user;

    @MappedCollection(idColumn = "habit_id")
    private Set<HabitEntry> habitEntries = new HashSet<>();

    public Habit(String title, Date dueDate, String description, LocalTime timeToComplete, AggregateReference<User, Integer> user) {
        super(title, dueDate, description);
        this.timeToComplete = timeToComplete;
        this.dueDate = dueDate;
        this.user = user;
    }

    public void addEntry(HabitEntry entry) {
        habitEntries.add(entry);
    }
}
