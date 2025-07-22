package com.phoenix.dto;

import com.phoenix.enums.Genre;
import com.phoenix.enums.Language;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMovieRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Duration is required")
    private int duration;

    @NotNull(message = "Rating is required")
    private Double rating;

    @NotBlank(message = "Description is required")
    private String description;
    @URL(message = "Invalid URL")
    private String posterUrl;

    @NotNull(message = "Release date is required")
    private LocalDate releaseDate;

    @NotEmpty(message = "Genres are required")
    List<Genre> genres;

    @NotEmpty(message = "Languages are required")
    List<Language> languages;
}
