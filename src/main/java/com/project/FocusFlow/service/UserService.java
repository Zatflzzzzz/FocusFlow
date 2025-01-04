package com.project.FocusFlow.service;

import com.project.FocusFlow.model.User;
import com.project.FocusFlow.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
