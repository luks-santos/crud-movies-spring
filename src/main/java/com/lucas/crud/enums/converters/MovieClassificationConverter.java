package com.lucas.crud.enums.converters;

import com.lucas.crud.enums.MovieClassification;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class MovieClassificationConverter implements AttributeConverter<MovieClassification, String> {
    @Override
    public String convertToDatabaseColumn(MovieClassification movieClassification) {
        if (movieClassification == null) {
            return null;
        }

        return movieClassification.getValue();
    }

    @Override
    public MovieClassification convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(MovieClassification.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
