package com.phoenix.controller;

import com.phoenix.dto.CreateMovieRequest;
import com.phoenix.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<?> createMovie(@Valid @RequestBody CreateMovieRequest request) {
        return movieService.createMovie(request);
    }

    @GetMapping
    public ResponseEntity<?> getMovies() {
        return movieService.getMovies();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMovie(String name) {
        return movieService.deleteMovie(name);
    }

    @PutMapping
    public ResponseEntity<?> updateMovie(String name, CreateMovieRequest request) {
        return movieService.updateMovie(name, request);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMovie(@PathVariable String name) {
        return movieService.getMovie(name);
    }


}
