package com.lucas.crud.controller;

import com.lucas.crud.dto.MovieDTO;
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
    public List<MovieDTO> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public MovieDTO findById(@PathVariable UUID id) {
        return movieService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MovieDTO save(@RequestBody MovieDTO movie) {
        return movieService.save(movie);
    }

    @PutMapping(value = "/{id}")
    public MovieDTO update(@PathVariable UUID id, @RequestBody MovieDTO obj) {
        return movieService.update(id, obj);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        movieService.delete(id);
    }
}
