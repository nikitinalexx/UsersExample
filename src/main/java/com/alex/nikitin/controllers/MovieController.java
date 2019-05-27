package com.alex.nikitin.controllers;

import com.alex.nikitin.model.dto.MovieDto;
import com.alex.nikitin.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDto>> cinemas(@RequestParam String namePattern) {
        List<MovieDto> movies = movieService.findByNamePattern(namePattern);
        return ResponseEntity.ok(movies);
    }

}
