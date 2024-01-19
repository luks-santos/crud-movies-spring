package com.lucas.crud.controller;

import com.lucas.crud.dto.MovieDTO;
import com.lucas.crud.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private final MovieService service;

    public MoviesController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<MovieDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MovieDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MovieDTO save(@RequestBody @Valid MovieDTO movie) {
        return service.save(movie);
    }

    @PutMapping(value = "/{id}")
    public MovieDTO update(@PathVariable UUID id, @RequestBody @Valid MovieDTO obj) {
        return service.update(id, obj);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
