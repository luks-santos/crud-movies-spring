package com.lucas.crud.dto.mapper;

import com.lucas.crud.dto.MovieDTO;
import com.lucas.crud.entities.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDTO toDTO(Movie movie) {
        if (movie == null) {
            return null;
        }
        return new MovieDTO(movie.getId(), movie.getName(), movie.getReleaseDate(),
                movie.getMovieDuration(), movie.getMovieClassification());
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
        movie.setMovieDuration(movieDTO.movieDuration());
        movie.setMovieClassification(movieDTO.movieClassification());

        return movie;
    }
}
