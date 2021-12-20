package com.movies.moviesapp.service.impl;

import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.repository.ActorRepository;
import com.movies.moviesapp.service.ActorQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorQueryServiceImpl implements ActorQueryService {

    private final ActorRepository actorRepository;

    public ActorQueryServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }


    @Override
    public Optional<Actor> findById(Long id) {
        return actorRepository.findById(id);
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public List<Actor> findByNameContaining(String name) {
        return actorRepository.findByNameContaining(name);
    }

}
