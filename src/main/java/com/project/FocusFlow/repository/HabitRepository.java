package com.project.FocusFlow.repository;

import com.project.FocusFlow.model.Habit;
import org.springframework.data.repository.CrudRepository;

public interface HabitRepository extends CrudRepository<Habit, Integer> {
}
