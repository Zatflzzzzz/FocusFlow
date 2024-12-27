package com.project.FocusFlow.database.repositories;

import com.project.FocusFlow.database.model.Habit;
import org.springframework.data.repository.CrudRepository;

public interface HabitRepository extends CrudRepository<Habit, Integer> {
}
