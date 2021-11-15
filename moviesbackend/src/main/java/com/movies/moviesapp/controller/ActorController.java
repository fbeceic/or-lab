package com.movies.moviesapp.controller;

import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.repository.ActorRepository;
import com.movies.moviesapp.response.ActorResponse;
import com.movies.moviesapp.service.ActorQueryService;
import com.movies.moviesapp.util.mapper.CreateMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorQueryService actorQueryService;


    private final CreateMapper<Actor, ActorResponse> actorActorResponseCreateMapper;

    public ActorController(ActorQueryService actorQueryService,
                           ActorRepository actorRepository, CreateMapper<Actor, ActorResponse> actorActorResponseCreateMapper) {
        this.actorQueryService = actorQueryService;
        this.actorActorResponseCreateMapper = actorActorResponseCreateMapper;
    }

    /**
     * Returns all actors.
     *
     * @return List of all actors
     */
    @GetMapping //localhost:9090/actors
    @ResponseStatus(HttpStatus.OK)
    public List<ActorResponse> findAll() {
        final List<Actor> articles = actorQueryService.findAll();

        return actorActorResponseCreateMapper.mapToList(articles);
    }


}
