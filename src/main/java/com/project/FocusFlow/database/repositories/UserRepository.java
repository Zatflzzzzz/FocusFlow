package com.project.FocusFlow.database.repositories;

import com.project.FocusFlow.database.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
