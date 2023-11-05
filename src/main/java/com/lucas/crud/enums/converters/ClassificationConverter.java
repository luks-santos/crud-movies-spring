package com.lucas.crud.enums.converters;

import com.lucas.crud.enums.Classification;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ClassificationConverter implements AttributeConverter<Classification, String> {
    @Override
    public String convertToDatabaseColumn(Classification classification) {
        if (classification == null) {
            return null;
        }
        return classification.getValue();
    }

    @Override
    public Classification convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Classification.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
