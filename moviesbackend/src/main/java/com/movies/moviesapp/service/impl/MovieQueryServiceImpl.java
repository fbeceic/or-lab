package com.movies.moviesapp.service.impl;

import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.entity.Movie;
import com.movies.moviesapp.repository.ActorRepository;
import com.movies.moviesapp.repository.MovieRepository;
import com.movies.moviesapp.service.ActorQueryService;
import com.movies.moviesapp.service.MovieQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieQueryServiceImpl implements MovieQueryService {

    private final MovieRepository movieRepository;

    public MovieQueryServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

}
