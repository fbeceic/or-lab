package com.movies.moviesapp.service;

import com.movies.moviesapp.entity.Actor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorQueryService {

    List<Actor> findAll();

}
