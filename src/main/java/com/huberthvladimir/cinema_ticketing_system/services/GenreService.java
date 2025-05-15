package com.huberthvladimir.cinema_ticketing_system.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huberthvladimir.cinema_ticketing_system.dtos.GenreDTO;
import com.huberthvladimir.cinema_ticketing_system.entities.Genre;
import com.huberthvladimir.cinema_ticketing_system.repositories.GenreRepository;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public List<GenreDTO> getListGenres() {
        List<GenreDTO> resultList = new ArrayList<>();
        List<Genre> genres = genreRepository.findAll();
        for (Genre genre : genres) {
            resultList.add(new GenreDTO(genre.getId(), genre.getName()));
        }
        return resultList;
    }

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
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        genreRepository.deleteById(genre.getId());
    }
}
