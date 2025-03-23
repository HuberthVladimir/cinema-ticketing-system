package com.huberthvladimir.cinema_ticketing_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huberthvladimir.cinema_ticketing_system.dtos.MovieDTO;
import com.huberthvladimir.cinema_ticketing_system.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Object> getListMovies() {
        var moviesList = movieService.getMoviesList();
        return ResponseEntity.ok(moviesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable Long id) {
        MovieDTO dto = movieService.searchMovieById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(MovieDTO dto) {
        return ResponseEntity.ok(movieService.createMovie(dto));
        // return ResponseEntity.ok(new MovieDTO());
    }
}
