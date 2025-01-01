package com.project.FocusFlow.repository;

import com.project.FocusFlow.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
