package com.huberthvladimir.cinema_ticketing_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huberthvladimir.cinema_ticketing_system.dtos.GenreDTO;
import com.huberthvladimir.cinema_ticketing_system.services.GenreService;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllGenre() {
        List<GenreDTO> dto = genreService.getListGenres();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> findById(@PathVariable Long id) {
        GenreDTO dto = genreService.getGenre(id);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> update(@PathVariable Long id, @RequestBody GenreDTO genreDTO) {
        GenreDTO dto = genreService.updateGenre(id, genreDTO);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<GenreDTO> create(@RequestBody GenreDTO genreDTO) {
        GenreDTO dto = genreService.createGenre(genreDTO);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
