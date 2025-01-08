package com.project.FocusFlow.service;

import com.project.FocusFlow.model.User;
import com.project.FocusFlow.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
