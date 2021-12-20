package com.movies.moviesapp.service;

import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.entity.Director;

import java.util.List;

public interface DirectorQueryService {

    List<Director> findAll();

}
