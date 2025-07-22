package com.phoenix.dao;

import com.phoenix.entity.Movie;
import com.phoenix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MovieDao {
    private final MovieRepository movieRepository;

    public Optional<Movie> findByName(String name) {
        return movieRepository.findByName(name);
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
