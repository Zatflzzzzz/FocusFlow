package com.project.FocusFlow.service;

import com.project.FocusFlow.config.MyUserDetails;
import com.project.FocusFlow.model.User;
import com.project.FocusFlow.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
    }
}
