package com.lucas.crud.service;

import com.lucas.crud.dto.MovieDTO;
import com.lucas.crud.dto.mapper.MovieMapper;
import com.lucas.crud.entities.Movie;
import com.lucas.crud.exception.RecordNotFoundException;
import com.lucas.crud.repositories.MovieRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieDTO> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(movieMapper::toDTO)
                .toList();
    }

    public MovieDTO findById(UUID id) {
        return movieRepository.findById(id)
                .map(movieMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public MovieDTO save(@Valid @NotNull MovieDTO obj) {
        return movieMapper.toDTO(movieRepository.save(movieMapper.toEntity(obj)));
    }

    public MovieDTO update(UUID id, @Valid @NotNull MovieDTO obj) {
        return movieRepository.findById(id)
            .map(entity -> {
                updateMovie(entity, movieMapper.toEntity(obj));
                return movieMapper.toDTO(movieRepository.save(entity));
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(UUID id) {
        movieRepository.delete(movieRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

    private void updateMovie(Movie entity, Movie obj) {
        entity.setName(obj.getName());
        entity.setReleaseDate(obj.getReleaseDate());
        entity.setDuration(obj.getDuration());
        entity.setClassification(obj.getClassification());
    }
}