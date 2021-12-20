package com.movies.moviesapp.controller;

import com.movies.moviesapp.controller.response.WrappedActorListResponse;
import com.movies.moviesapp.controller.response.WrappedActorResponse;
import com.movies.moviesapp.exception.ApiRequestException;
import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.repository.ActorRepository;
import com.movies.moviesapp.controller.response.ActorResponse;
import com.movies.moviesapp.util.mapper.CreateMapper;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorRepository actorRepository;

    private final CreateMapper<Actor, WrappedActorResponse> actorWrappedActorResponseCreateMapper;

    public ActorController(ActorRepository actorRepository, CreateMapper<Actor, ActorResponse> actorActorResponseCreateMapper, CreateMapper<Actor, WrappedActorResponse> actorWrappedActorResponseCreateMapper, CreateMapper<List<Actor>, WrappedActorListResponse> actorListWrappedActorResponseCreateMapper) {
        this.actorRepository = actorRepository;
        this.actorWrappedActorResponseCreateMapper = actorWrappedActorResponseCreateMapper;
    }

    /**
     * Returns all actors.
     *
     * @return List of all actors
     */
    @GetMapping //localhost:9090/actors
    @ResponseStatus(HttpStatus.OK)
    public WrappedActorListResponse findAllActors() {
        final List<Actor> actors = actorRepository.findAll();

        return new WrappedActorListResponse("OK","Fetched all actors", actors);
    }

    /**
     * Returns an actor by ID.
     * @param id Request describing the actor's id
     * @return Actor with the specified ID
     */
    @GetMapping ("/id/{id}") //localhost:9090/actors
    @ResponseStatus(HttpStatus.OK)
    public WrappedActorResponse findActorsById(@PathVariable Long id) {

        final Optional<Actor> actor = actorRepository.findById(id);

        if (actor.isPresent()) {

            return actorWrappedActorResponseCreateMapper.map(actor.get());

        } else {

            throw new ApiRequestException("ACTOR_ID");
        }
    }

    /**
     * Returns an actor by name.
     * @param name Request describing the actor's name
     * @return Actor with the specified name
     */
    @GetMapping ("/name/{name}") //localhost:9090/actors
    @ResponseStatus(HttpStatus.OK)
    public List<WrappedActorResponse> findByName(@PathVariable String name) {

        final List<Actor> actor = actorRepository.findByNameContaining(name);

        if (!actor.isEmpty()) {

            return actorWrappedActorResponseCreateMapper.mapToList(actor);

        } else {

            throw new ApiRequestException("ACTOR_NAME");
        }
    }
}
