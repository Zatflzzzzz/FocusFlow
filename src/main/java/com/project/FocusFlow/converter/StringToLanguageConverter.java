package com.project.FocusFlow.converter;

import com.project.FocusFlow.enums.Language;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class StringToLanguageConverter implements Converter<String, Language> {
    @Override
    public Language convert(String source) {
        return Language.valueOf(source);
    }
}
