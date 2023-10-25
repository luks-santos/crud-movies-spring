package com.lucas.crud;

import com.lucas.crud.entities.Movie;
import com.lucas.crud.entities.MovieClassification;
import com.lucas.crud.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class CrudMoviesTvserieSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudMoviesTvserieSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(MovieRepository movieRepository) {
        return args -> {
            movieRepository.deleteAll();
            Movie m = new Movie();
            m.setName("Clube da Luta");
            m.setReleaseDate("1999");
            m.setMovieDuration("2h 19m");
            m.setMovieClassification(MovieClassification.BOM);
            movieRepository.save(m);
        };
    }
}
