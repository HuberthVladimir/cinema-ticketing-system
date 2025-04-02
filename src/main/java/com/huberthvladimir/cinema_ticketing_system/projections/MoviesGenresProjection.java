package com.huberthvladimir.cinema_ticketing_system.projections;

import java.util.List;

public interface MoviesGenresProjection {

    Long getId();

    String getTitle();

    Integer getDuration();

    String getDescription();

    String getPosterImage();

    String getDirector();

    String getMovieCast();

    Double getBasePrice();

    List<String> getGenres();
}
