package com.movies.moviesapp.service;

import com.movies.moviesapp.entity.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorQueryService {

    Optional<Actor> findById(Long id);

    List<Actor> findAll();

    List<Actor> findByNameContaining(String name);


}
