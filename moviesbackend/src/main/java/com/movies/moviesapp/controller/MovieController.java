package com.movies.moviesapp.controller;


import com.movies.moviesapp.controller.response.MovieResponse;
import com.movies.moviesapp.controller.response.WrappedMovieListResponse;
import com.movies.moviesapp.controller.response.WrappedMovieResponse;
import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.entity.Director;
import com.movies.moviesapp.entity.Movie;
import com.movies.moviesapp.exception.ApiRequestException;
import com.movies.moviesapp.repository.ActorRepository;
import com.movies.moviesapp.repository.DirectorRepository;
import com.movies.moviesapp.repository.MovieRepository;
import com.movies.moviesapp.util.mapper.CreateMapper;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    private final ActorRepository actorRepository;

    private final DirectorRepository directorRepository;


    private final CreateMapper<Movie, MovieResponse> movieMovieResponseCreateMapper;

    public MovieController(MovieRepository movieRepository, ActorRepository actorRepository, DirectorRepository directorRepository, CreateMapper<Movie, MovieResponse> movieMovieResponseCreateMapper) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
        this.movieMovieResponseCreateMapper = movieMovieResponseCreateMapper;
    }

    //LAB3:
    /**
     * Returns all movies wrapped.
     *
     * @return List of all movies wrapped
     */
    @GetMapping ("/wrapped")//localhost:9090/movies
    @ResponseStatus(HttpStatus.OK)
    public WrappedMovieListResponse findAllWrapped() {

        List<Movie> movies = movieRepository.findAll();

        if (!movies.isEmpty()) {
            return new WrappedMovieListResponse("OK","Fetched all movies", movies);
        } else {
            throw new ApiRequestException("MOVIES");
        }
    }

    @PutMapping("/wrapped")
    @ResponseStatus(HttpStatus.OK)
    public void notSupported() {
            throw new ApiRequestException("MOVIES_PUT");
    }

    @PatchMapping("/wrapped")
    @ResponseStatus(HttpStatus.OK)
    public void notImplemented() {
        throw new ApiRequestException("MOVIES_PUT");
    }

    /**
     * Returns all movies containing gross search term.
     *
     * @param imdbRating Request describing the worldwide gross of the movie
     * @return List of movies containing search term
     */
    @GetMapping("/wrapped/imdb/{imdbRating}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public WrappedMovieListResponse findByIMDbRatingWrapped(@PathVariable String imdbRating) {

        List<Movie> movies = movieRepository.findByRating(Double.valueOf(imdbRating));

        if (!movies.isEmpty()) {
            return new WrappedMovieListResponse("OK","Fetched all movies with the desired IMDb rating", movies);
        } else {
            throw new ApiRequestException("IMDB");
        }
    }

    /**
     * Add a new movie
     *
     * @param movie Request describing new movie to be created
     * @return List of added movie wrapped
     */
    @PostMapping ("/wrapped")//localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public WrappedMovieResponse addMovie(@RequestBody Movie movie) {

        directorRepository.save(movie.getDirector());
        actorRepository.saveAll(movie.getActors());

        final Movie createdMovie = movieRepository.save(movie);

        return new WrappedMovieResponse("OK","Successfully added a new movie", createdMovie);

    }

    /**
     * Edit an existing movie
     *
     * @param newMovie Request describing modified movie
     * @param id Request describing the movie to be modified
     * @return List of modified movie wrapped
     */
    @PutMapping ("/wrapped/{id}")//localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public WrappedMovieResponse editMovie(@RequestBody Movie newMovie, @PathVariable Long id) {

        Optional<Movie> foundMovie = movieRepository.findById(id);

        if(foundMovie.isPresent()) {
            foundMovie
                    .map(movie -> {
                        movie.setName(newMovie.getName());
                        movie.setCountry(newMovie.getCountry());
                        movie.setYear(newMovie.getYear());
                        movie.setDuration(newMovie.getDuration());
                        movie.setGenre1(newMovie.getGenre1());
                        movie.setGenre2(newMovie.getGenre2());
                        movie.setDirector(newMovie.getDirector());
                        movie.setActors(newMovie.getActors());
                        movie.setMparating(newMovie.getMparating());
                        movie.setBudget(newMovie.getBudget());
                        movie.setGross(newMovie.getGross());
                        movie.setRating(newMovie.getRating());
                        return movieRepository.save(movie);
                    });
            return new WrappedMovieResponse("OK","Successfully modified a movie", newMovie);
        } else {
            throw new ApiRequestException("EDIT_MOVIE");
        }
    }

    /**
     * Delete an existing movie
     *
     * @param id Request describing a movie to be deleted
     * @return Status of deletion
     */
    @DeleteMapping ("/wrapped/{id}")//localhost:9090/movies
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteMovie(@PathVariable Long id) {

        Optional<Movie> foundMovie = movieRepository.findById(id);

        if(foundMovie.isPresent()) {
            movieRepository.delete(foundMovie.get());
            return "Successfully deleted the movie with the desired ID";

        } else {
            throw new ApiRequestException("EDIT_MOVIE");
        }
    }

    ////////////////////////////


    /**
     * Returns all movies.
     *
     * @return List of all movies
     */
    @GetMapping //localhost:9090/movies
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> findAll() {

        List<Movie> movies = movieRepository.findAll();

        return movies;
    }

    /**
     * Returns all movies containing name search term.
     *
     * @param name Request describing movie name
     * @return List of movies containing search term
     */
    @GetMapping("/name/{name}") //localhost:9090/movies
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
    @GetMapping("/country/{country}") //localhost:9090/movies
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
    @GetMapping("/year/{year}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByYear(@PathVariable String year) {

        return movieRepository.findByYear(Integer.parseInt(year));
    }

    /**
     * Returns all movies containing duration search term.
     *
     * @param duration Request describing the duration (in minutes) of a movie
     * @return List of movies containing search term
     */
    @GetMapping("/duration/{duration}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByDuration(@PathVariable String duration) {

        return movieRepository.findByDuration(Integer.parseInt(duration));
    }

    /**
     * Returns all movies containing genre search term.
     *
     * @param genre Request describing the genre of a movie
     * @return List of movies containing search term
     */
    @GetMapping("/genre/{genre}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> findByGenre(@PathVariable String genre) {

        List<Movie> movies = movieRepository.findByGenre1OrGenre2Containing(genre, genre);

        if (!movies.isEmpty()) {
            return movies;
        } else {
            throw new ApiRequestException("GENRE");
        }
    }

    /**
     * Returns all movies containing director's name search term.
     *
     * @param directorName Request describing the director of the movie
     * @return List of movies containing search term
     */
    @GetMapping("/director/{directorName}") //localhost:9090/movies
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
    @GetMapping("/actor/{actorName}") //localhost:9090/movies
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
    @GetMapping("/mparating/{mpaRating}") //localhost:9090/movies
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
    @GetMapping("/budget/{budget}") //localhost:9090/movies
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
    @GetMapping("/gross/{gross}") //localhost:9090/movies
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
    @GetMapping("/imdb/{imdbRating}") //localhost:9090/movies
    @ResponseStatus(HttpStatus.CREATED)
    public List<MovieResponse> findByIMDbRating(@PathVariable String imdbRating) {

        List<Movie> movies = movieRepository.findByRating(Double.valueOf(imdbRating));

        if (!movies.isEmpty()) {
            return movieMovieResponseCreateMapper.mapToList(movies);
        } else {
            throw new ApiRequestException("IMDB");
        }
    }
    
    /**
     * Returns all movies containing a wildcard search term.
     *
     * @param wildcard Request describing a wildcard search term of the movie
     * @return List of movies containing search term
     */
    @GetMapping("/wildcard/{wildcard}") //localhost:9090/movies
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
        if (foundMoviesIntegers.isEmpty()) {
            try {
                var doubleVal = Double.valueOf(wildcard);

                System.out.println(Double.valueOf(wildcard));

                foundMoviesIntegers = Stream.of(movieRepository.findByRating(doubleVal))
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
            } catch (Exception ex) {
                System.out.println("Search term is not double.");
            }
        }

        if (foundMoviesIntegers.isEmpty()) {
            foundMovies = Stream.of(movieRepository.findByNameContaining(wildcard),
                            movieRepository.findByCountryContaining(wildcard),
                            movieRepository.findByGenre1OrGenre2Containing(wildcard,wildcard),
                            movieRepository.findByDirector_NameOrDirector_Surname(wildcard,wildcard),
                            movieRepository.findByActorsIn(foundActors),
                            movieRepository.findByMparatingContaining(wildcard))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            return foundMovies;
        } else {
            return foundMoviesIntegers;

        }

    }

}
