package com.lucas.crud.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(length = 20, nullable = false)
    private String category;

}
