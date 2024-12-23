package com.project.FocusFlow.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        createTables();
    }

    public void createTables() {
        String createUserTableSql = """
                CREATE TABLE IF NOT EXISTS users (
                          id SERIAL PRIMARY KEY,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          username VARCHAR(255) NOT NULL UNIQUE,
                          role VARCHAR(50) NOT NULL,
                          telegram_name VARCHAR(50),
                          profile_picture VARCHAR(255),
                          status VARCHAR(50),
                          number_of_violations INT CHECK (number_of_violations >= 0),
                          last_activity TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                      );
            """;

        jdbcTemplate.execute(createUserTableSql);
        //System.out.println("Table 'users' created successfully!");
    }
}
