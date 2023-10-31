package com.lucas.crud.service;

import com.lucas.crud.entities.Movie;
import com.lucas.crud.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public ResponseEntity<Movie> findById(UUID id) {
        return movieRepository.findById(id)
                .map(entity -> ResponseEntity.ok().body(entity))
                .orElse(ResponseEntity.notFound().build());
    }

    public Movie save(Movie obj) { return movieRepository.save(obj); }

    public ResponseEntity<Movie> update(UUID id, Movie obj) {
        return movieRepository.findById(id)
                .map(entity -> {
                    updateMovie(entity, obj);
                    Movie updated = movieRepository.save(entity);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    private void updateMovie(Movie entity, Movie obj) {
        entity.setName(obj.getName());
        entity.setReleaseDate(obj.getReleaseDate());
        entity.setMovieDuration(obj.getMovieDuration());
        entity.setMovieClassification(obj.getMovieClassification());
    }

    public ResponseEntity<Void> delete(UUID id) {
        return movieRepository.findById(id)
                .map(entity -> {
                    movieRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());

    }
}
