package com.lucas.crud.service;

import com.lucas.crud.dto.MovieDTO;
import com.lucas.crud.dto.MoviePageDTO;
import com.lucas.crud.dto.mapper.MovieMapper;
import com.lucas.crud.entities.Movie;
import com.lucas.crud.exception.RecordNotFoundException;
import com.lucas.crud.repositories.MovieRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public MoviePageDTO findAll(@PositiveOrZero int page, @Positive @Max(100) int pageSize) {
        Page<Movie> pageMovies = movieRepository.findAll(PageRequest.of(page, pageSize));
        List<MovieDTO> movies = pageMovies.map(movieMapper::toDTO).toList();
        return new MoviePageDTO(movies, pageMovies.getTotalPages(), pageMovies.getTotalElements());
    }

    public MovieDTO findById(UUID id) {
        return movieRepository.findById(id)
                .map(movieMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public MovieDTO save(MovieDTO obj) {
        return movieMapper.toDTO(movieRepository.save(movieMapper.toEntity(obj)));
    }

    public MovieDTO update(UUID id, MovieDTO obj) {
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

        //Mantêm a referência do objeto lista, assim o jpa entende que deve atualizar os comentários
        entity.getComments().clear();
        obj.getComments().forEach(comment -> entity.getComments().add(comment));
    }
}