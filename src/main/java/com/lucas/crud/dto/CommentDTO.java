package com.lucas.crud.dto;

import java.util.UUID;

public record CommentDTO (
        UUID id,
        String review) { }
