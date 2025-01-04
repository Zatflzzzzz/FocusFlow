package com.project.FocusFlow.converter;

import com.project.FocusFlow.enums.Themes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class StringToThemesConverter implements Converter<String, Themes> {
    @Override
    public Themes convert(String source) {
        return Themes.valueOf(source);
    }
}
