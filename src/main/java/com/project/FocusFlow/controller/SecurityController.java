package com.project.FocusFlow.controller;

import com.project.FocusFlow.dto.SignInRequest;
import com.project.FocusFlow.dto.SignUpRequest;
import com.project.FocusFlow.model.User;
import com.project.FocusFlow.repository.UserRepository;
import com.project.FocusFlow.security.JwtTokenProvider;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/auth")
public class SecurityController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtTokenProvider(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/signUp")
    ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different username");
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different email");
        }

        String hashedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        User user = new User(
                signUpRequest.getEmail(),
                hashedPassword,
                signUpRequest.getUsername(),
                signUpRequest.getRole(),
                signUpRequest.getTelegramLink(),
                signUpRequest.getProfilePicture(),
                signUpRequest.getStatus(),
                signUpRequest.getNumberOfViolations()
        );

        userRepository.save(user);
        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }

    @PostMapping("/signIn")
    ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest) {
        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),
                    signInRequest.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }
}
