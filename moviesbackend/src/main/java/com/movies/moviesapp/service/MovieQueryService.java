package com.movies.moviesapp.service;
import com.movies.moviesapp.entity.Movie;

import java.util.List;

public interface MovieQueryService {

    List<Movie> findAll();

}
