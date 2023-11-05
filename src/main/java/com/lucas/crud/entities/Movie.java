package com.lucas.crud.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLSelect;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor()
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
    @Enumerated
    private MovieClassification movieClassification;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";
}
