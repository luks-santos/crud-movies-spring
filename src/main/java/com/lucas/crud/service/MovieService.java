package com.lucas.crud.service;

import com.lucas.crud.entities.Movie;
import com.lucas.crud.repositories.MovieRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(UUID id) {
        return movieRepository.findById(id);
    }

    public Movie save(@Valid Movie obj) { return movieRepository.save(obj); }

    public Optional<Movie> update(UUID id, @Valid Movie obj) {
        return movieRepository.findById(id)
            .map(entity -> {
                updateMovie(entity, obj);
                return movieRepository.save(entity);
            });
    }

    private void updateMovie(Movie entity, Movie obj) {
        entity.setName(obj.getName());
        entity.setReleaseDate(obj.getReleaseDate());
        entity.setMovieDuration(obj.getMovieDuration());
        entity.setMovieClassification(obj.getMovieClassification());
    }

    public boolean delete(UUID id) {
        return movieRepository.findById(id)
                .map(entity -> {
                    movieRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }
}
