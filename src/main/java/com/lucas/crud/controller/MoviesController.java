package com.lucas.crud.controller;

import com.lucas.crud.entities.Movie;
import com.lucas.crud.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor //lombok construtor com argumentos
public class MoviesController {

    //@Autowired Se a classe realmente precisa da instância do service é preferível utilizar o construtor
    private final MovieService movieService;

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie save(@RequestBody Movie movie) {
        //return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.save(movie));
        return this.movieService.save(movie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable UUID id) {
        return this.movieService.findById(id);
    }
}
