package com.lucas.crud.dto;

import java.util.List;

public record MoviePageDTO(List<MovieDTO> content, int totalPages, long totalElements) {

}
