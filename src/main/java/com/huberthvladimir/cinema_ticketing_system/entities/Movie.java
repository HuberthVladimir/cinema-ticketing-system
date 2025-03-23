package com.huberthvladimir.cinema_ticketing_system.entities;

import java.util.HashSet;
import java.util.Set;

import com.huberthvladimir.cinema_ticketing_system.dtos.MovieDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer duration;

    @Column(length = 3000)
    private String description;

    private String posterImage;

    private String director;

    @Column(name = "movie_cast")
    private String cast;

    private Double basePrice;

    @ManyToMany
    @JoinTable(name = "tb_movies_genres", joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    public Movie() {}

    public Movie(Long id, String title, Integer duration, String description, String posterImage,
            String director, String cast, Double basePrice) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.posterImage = posterImage;
        this.director = director;
        this.cast = cast;
        this.basePrice = basePrice;
    }

    public Movie(MovieDTO dto) {
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.duration = dto.getDuration();
        this.description = dto.getDescription();
        this.posterImage = dto.getPosterImage();
        this.director = dto.getDirector();
        this.cast = dto.getCast();
        this.basePrice = dto.getBasePrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Genre genre) {
        genres.add(genre);
    }
}
