package com.project.FocusFlow.database.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Table("habits")
public class Habit extends Action{
    @Id
    private Integer id;
    private String timeToComplete;

    @Column("person_id")
    private AggregateReference<User, Integer> person;

    @MappedCollection(idColumn = "habit_id")
    private Set<HabitEntries> habitEntries = new HashSet<>();

    public Habit(String title, Date dueDate, String description, String timeToComplete, AggregateReference<User, Integer> person) {
        super(title, dueDate, description);
        this.timeToComplete = timeToComplete;
        this.person = person;
    }

    public void addHabitEntry(HabitEntries entry) {
        habitEntries.add(entry);
    }
}
