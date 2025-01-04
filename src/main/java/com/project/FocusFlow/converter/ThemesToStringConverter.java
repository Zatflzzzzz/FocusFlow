package com.project.FocusFlow.converter;

import com.project.FocusFlow.enums.Themes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class ThemesToStringConverter implements Converter<Themes, String> {
    @Override
    public String convert(Themes source) {
        return source.name();
    }
}

