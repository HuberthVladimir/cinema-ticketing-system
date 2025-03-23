package com.huberthvladimir.cinema_ticketing_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.huberthvladimir.cinema_ticketing_system.entities.Movie;
import com.huberthvladimir.cinema_ticketing_system.projections.MoviesGenresProjection;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = """
                SELECT movies.*, genres.NAME as genre
                FROM TB_MOVIES movies
                INNER JOIN TB_MOVIES_GENRES movies_genres
                ON movies.ID = movies_genres.MOVIE_ID
                INNER JOIN TB_GENRES
                genres ON genres.ID=movies_genres.GENRE_ID
            """)
    List<MoviesGenresProjection> searchMoviesAndGenres();

    @Query(nativeQuery = true, value = """
                SELECT movies.*, genres.NAME as genre
                FROM TB_MOVIES movies
                INNER JOIN TB_MOVIES_GENRES movies_genres
                ON movies.ID = movies_genres.MOVIE_ID
                INNER JOIN TB_GENRES
                genres ON genres.ID=movies_genres.GENRE_ID
                WHERE movies.ID = :id
            """)
    MoviesGenresProjection searchMovieById(Long id);
}
