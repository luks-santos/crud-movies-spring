package com.lucas.crud.dto;

import com.lucas.crud.enums.Classification;
import com.lucas.crud.enums.validations.ValueOfEnum;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.UUID;

public record MovieDTO(
        UUID _id,
        @NotBlank(message = "Name field is mandatory.")
        @Size(min = 1, max = 50, message = "Name field must have a maximum of 50 characters.")
        String name,
        @Min(value = 1888, message = "Release date must be greater than or equal to 1888.")
        @Max(value = 9999, message = "Release date must be less than or equal to 9999.")
        int releaseDate,
        @NotBlank(message = "Duration field is mandatory")
        @Pattern(regexp = "^([1-9]\\d{0,2}h)?\\s?([1-5]?\\d?m)?$", message = "Please enter a valid movie duration. " +
                "Use the format 'Xh Ym' where X is the number of hours (1 to 999) and Y is the number of minutes (1 to 59). " +
                "Example: '2h 30m'.")
        String duration,
        @ValueOfEnum(enumClass = Classification.class)
        @NotBlank(message = "Classification field is mandatory.")
        String classification,
        List<CommentDTO> comments
) { }
