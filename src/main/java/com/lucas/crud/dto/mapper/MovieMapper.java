package com.lucas.crud.dto.mapper;

import com.lucas.crud.dto.CommentDTO;
import com.lucas.crud.dto.MovieDTO;
import com.lucas.crud.entities.Movie;
import com.lucas.crud.enums.Classification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    public MovieDTO toDTO(Movie movie) {
        if (movie == null) {
            return null;
        }
        List<CommentDTO> comments = movie.getComments()
                .stream()
                .map(comment -> new CommentDTO(comment.getId(), comment.getReview()))
                .toList();
        return new MovieDTO(movie.getId(), movie.getName(), movie.getReleaseDate(),
                movie.getDuration(), movie.getClassification().getValue(), comments);
    }

    public Movie toEntity(MovieDTO movieDTO) {

        if (movieDTO == null) {
            return null;
        }

        Movie movie = new Movie();
        if (movieDTO._id() != null) {
            movie.setId(movieDTO._id());
        }

        movie.setName(movieDTO.name());
        movie.setReleaseDate(movieDTO.releaseDate());
        movie.setDuration(movieDTO.duration());
        movie.setClassification(convertClassificationValue(movieDTO.classification()));

        return movie;
    }

    public Classification convertClassificationValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Ruim" -> Classification.BAD;
            case "Bom" -> Classification.GOD;
            case "Excelente" -> Classification.EXCELLENT;
            default -> throw new IllegalArgumentException("Categoria inválida " + value);
        };
    }
}
