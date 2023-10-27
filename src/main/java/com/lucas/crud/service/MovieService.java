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

    public Movie save(Movie movie) { return movieRepository.save(movie); }

    public ResponseEntity<Movie> findById(UUID id) {
        return movieRepository.findById(id)
                .map(movie -> ResponseEntity.ok().body(movie))
                .orElse(ResponseEntity.notFound().build());
    }
}
