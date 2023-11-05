package com.lucas.crud;

import com.lucas.crud.entities.Movie;
import com.lucas.crud.entities.MovieClassification;
import com.lucas.crud.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CrudMoviesTvserieSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudMoviesTvserieSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(MovieRepository movieRepository) {
        return args -> {
            movieRepository.deleteAll();
            List<Movie> movies = new ArrayList<>();
            movies.add(new Movie(null, "Clube da Luta", 1999, "2h 19m", MovieClassification.EXCELENTE, "Ativo"));
            movies.add(new Movie(null, "Saw", 2005, "1h 40m", MovieClassification.BOM, "Ativo"));
            movieRepository.saveAll(movies);
        };
    }
}
