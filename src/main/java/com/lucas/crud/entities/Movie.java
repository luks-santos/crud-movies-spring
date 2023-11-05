package com.lucas.crud.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucas.crud.enums.MovieClassification;
import com.lucas.crud.enums.converters.MovieClassificationConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.util.UUID;


@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE movie SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("_id")
    private UUID id;

    @NotBlank
    @NotNull
    @Length(min = 1, max = 50)
    @Column(length = 50, nullable = false)
    private String name;

    @NotNull
    @Range(min = 1888, max = 9999)
    @Column(nullable = false)
    private int releaseDate;

    @NotNull
    @Length(min = 5, max = 7)
    @Pattern(regexp = "^\\d{1,2}h \\d{1,2}m$")
    @Column(length = 7, nullable = false)
    private String movieDuration;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = MovieClassificationConverter.class)
    private MovieClassification movieClassification;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";
}
