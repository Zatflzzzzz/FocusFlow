package com.project.FocusFlow.database.repository;

import com.project.FocusFlow.database.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
