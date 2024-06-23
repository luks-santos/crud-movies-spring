package com.lucas.crud.entities;

import com.lucas.crud.enums.Classification;
import com.lucas.crud.enums.Status;
import com.lucas.crud.enums.converters.ClassificationConverter;
import com.lucas.crud.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



@Entity
@SQLDelete(sql = "UPDATE movie SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "Name field is mandatory.")
    @Size(min = 1, max = 50, message = "Name field must have a maximum of 50 characters.")
    private String name;

    @Column(nullable = false)
    @Min(value = 1888, message = "Release date must be greater than or equal to 1888.")
    @Max(value = 9999, message = "Release date must be less than or equal to 9999.")
    private int releaseDate;

    @Column(length = 7, nullable = false)
    @NotBlank(message = "Duration field is mandatory")
    @Pattern(regexp = "^([1-9]\\d{0,2}h)?\\s?([1-5]?\\d?m)?$", message = "Please enter a valid movie duration. " +
            "Use the format 'Xh Ym' where X is the number of hours (1 to 999) and Y is the number of minutes (1 to 59). " +
            "Example: '2h 30m'.")
    private String duration;

    @Column(length = 10, nullable = false)
    @NotNull(message = "Classification field is mandatory.")
    @Convert(converter = ClassificationConverter.class)
    private Classification classification;

    @Column(length = 10, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "movie")
    //@JoinColumn(name = "movie_id")
    private List<Comment> comments = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
