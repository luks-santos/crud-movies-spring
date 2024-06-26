package com.lucas.crud;

import com.lucas.crud.entities.Comment;
import com.lucas.crud.entities.Movie;
import com.lucas.crud.enums.Classification;
import com.lucas.crud.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudMoviesTvserieSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudMoviesTvserieSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(MovieRepository movieRepository) {
        return args -> {
            movieRepository.deleteAll();
            for (int i = 0; i < 20; i++) {
                Movie movie = new Movie();
                movie.setName("Filme " + i);
                movie.setReleaseDate(1999 + i);
                movie.setDuration("2h 19m");
                movie.setClassification(Classification.EXCELLENT);

                Comment c1 = new Comment();
                c1.setReview("hehehe");
                c1.setMovie(movie);
                movie.getComments().add(c1);

                Comment c2 = new Comment();
                c2.setReview("hehehe");
                c2.setMovie(movie);

                movie.getComments().add(c2);
                movieRepository.save(movie);
            }

        };
    }
}
