package com.lucas.crud.dto;

import com.lucas.crud.enums.Classification;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.util.UUID;

public record MovieDTO(
        UUID _id,
        @NotBlank @NotNull String name,
        @NotNull @Range(min = 1888, max = 9999)int releaseDate,
        @NotNull  @Length(min = 5, max = 7) @Pattern(regexp = "^\\d{1,2}h \\d{1,2}m$") String duration,
        @NotNull String classification) {
}
