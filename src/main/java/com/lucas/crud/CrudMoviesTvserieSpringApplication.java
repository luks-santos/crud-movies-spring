package com.lucas.crud;

import com.lucas.crud.entities.Movie;
import com.lucas.crud.enums.Classification;
import com.lucas.crud.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


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

            Movie movie = new Movie();
            movie.setName("Clube da Luta");
            movie.setReleaseDate(1999);
            movie.setDuration("2h 19m");
            movie.setClassification(Classification.EXCELLENT);

            Movie movie1 = new Movie();
            movie1.setName("Saw");
            movie1.setReleaseDate(2005);
            movie1.setDuration("1h 40m");
            movie1.setClassification(Classification.GOD);

            movies.add(movie);
            movies.add(movie1);
            movieRepository.saveAll(movies);
        };
    }
}
