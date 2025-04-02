package com.huberthvladimir.cinema_ticketing_system.dtos;

import java.util.ArrayList;
import java.util.List;

import com.huberthvladimir.cinema_ticketing_system.entities.Genre;
import com.huberthvladimir.cinema_ticketing_system.entities.Movie;
import com.huberthvladimir.cinema_ticketing_system.projections.MoviesGenresProjection;

public class MovieDTO {

    private Long id;

    private String title;

    private Integer duration;

    private String description;

    private String posterImage;

    private String director;

    private String cast;

    private Double basePrice;

    private List<String> genres = new ArrayList<>();

    public MovieDTO() {}

    public MovieDTO(Long id, String title, Integer duration, String description, String posterImage,
            String director, String cast, Double basePrice, List<String> genres) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.posterImage = posterImage;
        this.director = director;
        this.cast = cast;
        this.basePrice = basePrice;
        this.genres = genres;
    }

    public MovieDTO(Movie movies) {
        this.id = movies.getId();
        this.title = movies.getTitle();
        this.duration = movies.getDuration();
        this.description = movies.getDescription();
        this.posterImage = movies.getPosterImage();
        this.director = movies.getDirector();
        this.cast = movies.getCast();
        this.basePrice = movies.getBasePrice();
        for (Genre genre : movies.getGenres()) {
            this.genres.add(genre.getName());
        }
    }

    public MovieDTO(MoviesGenresProjection projection) {
        this.id = projection.getId();
        this.title = projection.getTitle();
        this.duration = projection.getDuration();
        this.description = projection.getDescription();
        this.posterImage = projection.getPosterImage();
        this.director = projection.getDirector();
        this.cast = projection.getMovieCast();
        this.basePrice = projection.getBasePrice();
        for (String genre : projection.getGenres()) {
            this.genres.add(genre);
        }

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public List<String> getGenres() {
        return genres;
    }
}
