package com.lucas.crud.service;

import com.lucas.crud.entities.Movie;
import com.lucas.crud.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie save(Movie movie) { return movieRepository.save(movie); }
}
