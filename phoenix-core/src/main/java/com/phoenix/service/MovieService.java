package com.phoenix.service;

import com.phoenix.dao.MovieDao;
import com.phoenix.dto.CreateMovieRequest;
import com.phoenix.entity.Movie;
import com.phoenix.entity.MovieGenre;
import com.phoenix.entity.MovieLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieDao movieDao;
    public ResponseEntity<String> createMovie(CreateMovieRequest request) {
        if(movieDao.findByName(request.getName()).isPresent()) {
            return ResponseEntity.badRequest().body("Movie already exists");
        }
        //can add mapper -> where? object mapper?
        Movie movie = Movie.builder()
                .name(request.getName())
                .duration(request.getDuration())
                .rating(request.getRating())
                .description(request.getDescription())
                .posterUrl(request.getPosterUrl())
                .releaseDate(request.getReleaseDate())
                .build();
        List<MovieGenre> genres = request.getGenres().stream().map(genre -> MovieGenre.builder().genre(genre).movie(movie).build()).toList();
        List<MovieLanguage> languages = request.getLanguages().stream().map(language -> MovieLanguage.builder().language(language).movie(movie).build()).toList();
        movie.setGenres(genres);
        movie.setLanguages(languages);
        movieDao.save(movie);
        return ResponseEntity.ok("Movie created successfully");
    }

    public ResponseEntity<?> getMovie(String name) {
        return movieDao.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> deleteMovie(String name) {
        movieDao.findByName(name)
                .ifPresent(movieDao::delete);
        return ResponseEntity.ok("Movie deleted successfully");
    }

    public ResponseEntity<?> updateMovie(String name, CreateMovieRequest request) {
        return movieDao.findByName(name)
                .map(movie -> {
                    Movie updatedMovie = Movie.builder()
                            .name(request.getName())
                            .duration(request.getDuration())
                            .rating(request.getRating())
                            .description(request.getDescription())
                            .posterUrl(request.getPosterUrl())
                            .releaseDate(request.getReleaseDate())
                            .build();
                    movieDao.save(updatedMovie);
                    return ResponseEntity.ok("Movie updated successfully");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> getMovies() {
        List<Movie> movies = movieDao.findAll();

        return ResponseEntity.ok(movies.stream().map(
                movie -> CreateMovieRequest.builder()
                        .name(movie.getName())
                        .duration(movie.getDuration())
                        .rating(movie.getRating())
                        .description(movie.getDescription())
                        .posterUrl(movie.getPosterUrl())
                        .releaseDate(movie.getReleaseDate())
                        .genres(movie.getGenres().stream().map(MovieGenre::getGenre).toList())
                        .languages(movie.getLanguages().stream().map(MovieLanguage::getLanguage).toList())
                        .build()
        ).toList());
    }
}
