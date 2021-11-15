package com.movies.moviesapp.repository;

import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {

    List<Movie> findAll();

    List<Movie> findByNameContaining(String name);

    List<Movie> findByCountryContaining(String country);

    List<Movie> findByYear(Integer year);

    List<Movie> findByDuration(Integer duration);

    List<Movie> findByGenre1OrGenre2Containing(String genre1, String genre2);

    List<Movie> findByDirector_NameOrDirector_Surname(String directorName, String directorSurname);

    List<Movie> findByActorsIn(List<Actor> actors);

    List<Movie> findByMparatingContaining(String rating);

    List<Movie> findByBudget(Integer budget);

    List<Movie> findByGross(Integer gross);

    List<Movie> findByRating(Double rating);

}
