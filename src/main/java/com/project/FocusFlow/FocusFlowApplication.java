package com.project.FocusFlow;

import com.project.FocusFlow.database.model.Habit;
import com.project.FocusFlow.database.model.HabitEntries;
import com.project.FocusFlow.database.model.User;
import com.project.FocusFlow.database.repositories.HabitRepository;
import com.project.FocusFlow.database.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.Calendar;
import java.sql.Date;

@SpringBootApplication
public class FocusFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(FocusFlowApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, HabitRepository habitRepository) {
		return args -> {
			AggregateReference<User, Integer> user = AggregateReference.to(
					userRepository.save(new User("email", "password", "test",
							"USER", "test", "test", "test", 0)).getId()
			);

			Habit habit = new Habit("TEST", Date.valueOf("2000-01-24"), "TEST", "TEST", user);

			habit.addHabitEntry(new HabitEntries(true));
			habit.addHabitEntry(new HabitEntries(false));

			habitRepository.save(habit);
		};
	}
}
