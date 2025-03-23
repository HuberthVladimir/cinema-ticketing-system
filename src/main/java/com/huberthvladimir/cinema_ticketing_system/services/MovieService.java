package com.huberthvladimir.cinema_ticketing_system.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huberthvladimir.cinema_ticketing_system.dtos.MovieDTO;
import com.huberthvladimir.cinema_ticketing_system.repositories.GenreRepository;
import com.huberthvladimir.cinema_ticketing_system.repositories.MovieRepository;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    GenreRepository genreRepository;

    public List<MovieDTO> getMoviesList() {
        var listMovies = movieRepository.searchMoviesAndGenres();
        List<MovieDTO> movies = new ArrayList<>();

        for (var movie : listMovies) {
            movies.add(new MovieDTO(movie));
        }

        return movies;
    }

    public MovieDTO searchMovieById(Long id) {
        var movie = movieRepository.searchMovieById(id);
        return new MovieDTO(movie);
    }

    public MovieDTO createMovie(MovieDTO dto) {
        // movieRepository.save(dto.);
        // Set<Genre> genres = dto.getGenres().stream().map(genre -> )
        return dto;
    }
}
