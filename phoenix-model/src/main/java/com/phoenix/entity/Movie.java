package com.phoenix.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie extends BaseEntity{
    private String name;
    private int duration;
    private Double rating;
    private String description;
    private String posterUrl;
    private LocalDate releaseDate; //DOUBT: Date/LocalDate

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovieGenre> genres;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovieLanguage> languages;

}
