package com.lucas.crud.controller;

import com.lucas.crud.entities.Movie;
import com.lucas.crud.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable UUID id) {
        return movieService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @PutMapping(value = "/{id}")
    public Movie update(@PathVariable UUID id, @RequestBody Movie newMovie) {
        return movieService.update(id, newMovie);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        movieService.delete(id);
    }
}
