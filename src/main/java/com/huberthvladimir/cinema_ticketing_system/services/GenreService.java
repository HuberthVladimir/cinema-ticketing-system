package com.huberthvladimir.cinema_ticketing_system.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.huberthvladimir.cinema_ticketing_system.dtos.GenreDTO;
import com.huberthvladimir.cinema_ticketing_system.entities.Genre;
import com.huberthvladimir.cinema_ticketing_system.repositories.GenreRepository;

public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public GenreDTO getGenre(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        return new GenreDTO(genre.getId(), genre.getName());
    }

    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = new Genre(null, genreDTO.getName());
        genre = genreRepository.save(genre);
        return new GenreDTO(genre.getId(), genre.getName());
    }

    public GenreDTO updateGenre(Long id, GenreDTO genreDTO) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        genre.setName(genreDTO.getName());
        genre = genreRepository.save(genre);
        return new GenreDTO(genre.getId(), genre.getName());
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
