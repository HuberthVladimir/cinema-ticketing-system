package com.huberthvladimir.cinema_ticketing_system.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huberthvladimir.cinema_ticketing_system.dtos.MovieDTO;
import com.huberthvladimir.cinema_ticketing_system.entities.Genre;
import com.huberthvladimir.cinema_ticketing_system.entities.Movie;
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
        var movie = movieRepository.searchMovieById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return new MovieDTO(movie);
    }

    public MovieDTO createMovie(MovieDTO dto) {
        var movie = new Movie(null, dto.getTitle(), dto.getDuration(), dto.getDescription(),
                dto.getPosterImage(), dto.getDirector(), dto.getCast(), dto.getBasePrice());

        for (String genre : dto.getGenres()) {
            Genre resultDB = genreRepository.findByName(genre)
                    .orElseThrow(() -> new RuntimeException("Genre not found"));
            movie.setGenres(resultDB);
        }
        movie = movieRepository.save(movie);
        return new MovieDTO(movie);
    }


    public MovieDTO updateMovie(Long id, MovieDTO dto) {
        var result = movieRepository.searchMovieById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Movie movie =
                new Movie(result.getId(), dto.getTitle(), dto.getDuration(), dto.getDescription(),
                        dto.getPosterImage(), dto.getDirector(), dto.getCast(), dto.getBasePrice());

        for (String genre : dto.getGenres()) {
            Genre resultDB = genreRepository.findByName(genre)
                    .orElseThrow(() -> new RuntimeException("Genre not found"));
            movie.setGenres(resultDB);
        }

        movie = movieRepository.save(movie);
        return new MovieDTO(movie);
    }

    public void deleteMovie(Long id) {
        var result = movieRepository.searchMovieById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movieRepository.deleteById(result.getId());
    }

}
