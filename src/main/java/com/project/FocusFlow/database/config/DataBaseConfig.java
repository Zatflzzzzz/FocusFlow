package com.project.FocusFlow.database.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {
    AppConfig appConfig;

    @Autowired
    DataBaseConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(appConfig.getDriverClassName());
        dataSource.setUrl(appConfig.getUrl());
        dataSource.setUsername(appConfig.getUserName());
        dataSource.setPassword(appConfig.getPassword());

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
