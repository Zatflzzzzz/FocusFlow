package com.project.FocusFlow;

import com.project.FocusFlow.model.Habit;
import com.project.FocusFlow.model.User;
import com.project.FocusFlow.repository.HabitRepository;
import com.project.FocusFlow.repository.TaskRepository;
import com.project.FocusFlow.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.time.LocalTime;

@SpringBootApplication
public class FocusFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(FocusFlowApplication.class, args);
	}

	/*@Bean
		return args -> {
			AggregateReference<User, Integer> user = AggregateReference.to(
				userRepository.save(new User(
						"example@email.com",
						"securePassword123",
						"username123",
						"USER",
						"https://t.me/example",
						"https://example.com/profile.jpg",
						"ACTIVE",
						0,
						1
				)).getId()
			);
		};*/
}
