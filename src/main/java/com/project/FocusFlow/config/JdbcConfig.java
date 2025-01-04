package com.project.FocusFlow.config;

import com.project.FocusFlow.converter.LanguageToStringConverter;
import com.project.FocusFlow.converter.StringToLanguageConverter;
import com.project.FocusFlow.converter.StringToThemesConverter;
import com.project.FocusFlow.converter.ThemesToStringConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;

import java.util.Arrays;

@Configuration
public class JdbcConfig {
    @Bean
    public CustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Arrays.asList(
                new ThemesToStringConverter(),
                new StringToThemesConverter(),
                new LanguageToStringConverter(),
                new StringToLanguageConverter()
        ));
    }
}
