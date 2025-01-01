package com.project.FocusFlow.repository;

import com.project.FocusFlow.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
