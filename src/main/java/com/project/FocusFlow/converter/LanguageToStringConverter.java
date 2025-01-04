package com.project.FocusFlow.converter;

import com.project.FocusFlow.enums.Language;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class LanguageToStringConverter implements Converter<Language, String> {
    @Override
    public String convert(Language source) {
        return source.name();
    }
}

