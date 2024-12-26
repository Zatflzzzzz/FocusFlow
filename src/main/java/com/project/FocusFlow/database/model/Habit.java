package com.project.FocusFlow.database.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table("habits")
public class Habit extends Action{
    @Id
    private Integer id;
    private String frequency;
    private AggregateReference<User, Integer> person;

    public Habit(String title, String timeToComplete, String frequency, AggregateReference<User, Integer> person) {
        super(title, timeToComplete);
        this.frequency = frequency;
        this.person = person;
    }
}
