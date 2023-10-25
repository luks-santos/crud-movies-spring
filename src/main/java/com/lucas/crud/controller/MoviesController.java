package com.lucas.crud.controller;

import com.lucas.crud.entities.Movie;
import com.lucas.crud.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Movie save(@RequestBody Movie movie) { return movieService.save(movie); }
}
