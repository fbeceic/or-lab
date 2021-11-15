package com.movies.moviesapp.controller;


import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.entity.Movie;
import com.movies.moviesapp.repository.ActorRepository;
import com.movies.moviesapp.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    private final ActorRepository actorRepository;

    public MovieController(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    /**
     * Returns all movies.
     *
     * @return List of all movies
     */
    @GetMapping //localhost:9090/movies
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> findAll() {

        return movieRepository.findAll();
    }

    /**
     * Returns all movies containing name search term.
     *
     * @param name Request describing movie name
     * @return List of movies containing search term
     */
    @PostMapping("/name/{name}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByName(@PathVariable String name) {

        return movieRepository.findByNameContaining(name);
    }

    /**
     * Returns all movies containing country search term.
     *
     * @param country Request describing movie country
     * @return List of movies containing search term
     */
    @PostMapping("/country/{country}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByCountry(@PathVariable String country) {

        return movieRepository.findByCountryContaining(country);
    }

    /**
     * Returns all movies containing year search term.
     *
     * @param year Request describing the year a movie came out
     * @return List of movies containing search term
     */
    @PostMapping("/year/{year}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByYear(@PathVariable String year) {

        return movieRepository.findByYear(Integer.parseInt(year));
    }

    /**
     * Returns all movies containing genre search term.
     *
     * @param genre Request describing the genre of a movie
     * @return List of movies containing search term
     */
    @PostMapping("/genre/{genre}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByGenre(@PathVariable String genre) {

        return movieRepository.findByGenre1OrGenre2Containing(genre,genre);
    }

    /**
     * Returns all movies containing director's name search term.
     *
     * @param directorName Request describing the director of the movie
     * @return List of movies containing search term
     */
    @PostMapping("/director/{directorName}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByDirector(@PathVariable String directorName) {


        return movieRepository.findByDirector_NameOrDirector_Surname(directorName, directorName);
    }

    /**
     * Returns all movies containing actor's name search term.
     *
     * @param actorName Request describing the actor of the movie
     * @return List of movies containing search term
     */
    @PostMapping("/actor/{actorName}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByActor(@PathVariable String actorName) {

        List<Actor> foundActors = new ArrayList<>();

        foundActors = Stream.of(actorRepository.findByNameContainingOrSurnameContaining(actorName,actorName))
                .flatMap(Collection::stream).distinct()
                .collect(Collectors.toList());

        return movieRepository.findByActorsIn(foundActors);
    }

    /**
     * Returns all movies containing mpa rating search term.
     *
     * @param mpaRating Request describing the mpa rating of the movie
     * @return List of movies containing search term
     */
    @PostMapping("/mparating/{mpaRating}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByMpaRating(@PathVariable String mpaRating) {


        return movieRepository.findByMparatingContaining(mpaRating);
    }

    /**
     * Returns all movies containing budget search term.
     *
     * @param budget Request describing the budget of the movie
     * @return List of movies containing search term
     */
    @PostMapping("/budget/{budget}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByBudget(@PathVariable String budget) {


        return movieRepository.findByBudget(Integer.valueOf(budget));
    }

    /**
     * Returns all movies containing gross search term.
     *
     * @param gross Request describing the worldwide gross of the movie
     * @return List of movies containing search term
     */
    @PostMapping("/gross/{gross}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByGross(@PathVariable String gross) {


        return movieRepository.findByGross(Integer.valueOf(gross));
    }

    /**
     * Returns all movies containing gross search term.
     *
     * @param imdbRating Request describing the worldwide gross of the movie
     * @return List of movies containing search term
     */
    @PostMapping("/imdb/{imdbRating}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByIMDbRating(@PathVariable String imdbRating) {


        return movieRepository.findByRating(Double.valueOf(imdbRating));
    }

    /**
     * Returns all movies containing a wildcard search term.
     *
     * @param wildcard Request describing a wildcard search term of the movie
     * @return List of movies containing search term
     */
    @PostMapping("/wildcard/{wildcard}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByWildcard(@PathVariable String wildcard) {

        List<Movie> foundMovies = new ArrayList<>();

        List<Movie> foundMoviesIntegers = new ArrayList<>();

        List<Actor> foundActors = new ArrayList<>();

        foundActors = Stream.of(actorRepository.findByNameContaining(wildcard),
                        actorRepository.findBySurnameContaining(wildcard))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        try {
            var integerVal = Integer.valueOf(wildcard);

            foundMoviesIntegers = Stream.of(movieRepository.findByYear(integerVal),
                            movieRepository.findByDuration(integerVal),
                            movieRepository.findByBudget(integerVal),
                            movieRepository.findByGross(integerVal))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            System.out.println("Search term is not integer.");
        }
        try {
            var doubleVal = Double.valueOf(wildcard);

            System.out.println(Double.valueOf(wildcard));

            foundMoviesIntegers = Stream.of(movieRepository.findByRating(doubleVal))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            System.out.println("Search term is not double.");
        }

        if (foundMoviesIntegers.isEmpty()) {
            foundMovies = Stream.of(movieRepository.findByNameContaining(wildcard),
                            movieRepository.findByCountryContaining(wildcard),
                            movieRepository.findByGenre1OrGenre2Containing(wildcard,wildcard),
                            movieRepository.findByDirector_NameOrDirector_Surname(wildcard,wildcard),
                            movieRepository.findByActorsIn(foundActors))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            return foundMovies;
        } else {
            return foundMoviesIntegers;

        }

    }

}
