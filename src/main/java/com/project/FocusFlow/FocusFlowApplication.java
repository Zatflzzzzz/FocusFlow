package com.project.FocusFlow;

import com.project.FocusFlow.database.model.User;
import com.project.FocusFlow.database.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FocusFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(FocusFlowApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			userRepository.save(new User("test", "test", "test", "test",
					"test", "test", "test", 0));
		};
	}
}
