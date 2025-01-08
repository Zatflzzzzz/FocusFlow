package com.project.FocusFlow.repository;

import com.project.FocusFlow.model.Habit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends CrudRepository<Habit, Integer> {
}
