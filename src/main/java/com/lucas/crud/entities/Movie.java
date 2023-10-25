package com.lucas.crud.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("_id")
    private UUID id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 4, nullable = false)
    private String releaseDate;

    @Column(length = 7, nullable = false)
    private String movieDuration;

    @Enumerated
    private MovieClassification movieClassification;
}
