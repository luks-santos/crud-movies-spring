package com.lucas.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CommentDTO (
        UUID id,
        @NotBlank(message = "Review field is mandatory.")
        @Size(max = 300, message = "Review must have a maximum of 300 characters")
        String review
) { }
