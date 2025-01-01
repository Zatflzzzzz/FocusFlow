package com.project.FocusFlow;

import com.project.FocusFlow.model.User;
import com.project.FocusFlow.repository.HabitRepository;
import com.project.FocusFlow.repository.TaskRepository;
import com.project.FocusFlow.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class FocusFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(FocusFlowApplication.class, args);
	}
}
