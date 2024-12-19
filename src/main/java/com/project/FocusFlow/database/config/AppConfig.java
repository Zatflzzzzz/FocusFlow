package com.project.FocusFlow.database.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Getter
public class AppConfig {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;
}
