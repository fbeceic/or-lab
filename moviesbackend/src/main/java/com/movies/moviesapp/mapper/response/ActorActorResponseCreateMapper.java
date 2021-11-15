package com.movies.moviesapp.mapper.response;

import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.response.ActorResponse;
import com.movies.moviesapp.service.ActorQueryService;
import com.movies.moviesapp.util.mapper.CreateMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActorActorResponseCreateMapper implements CreateMapper<Actor, ActorResponse> {

    private final ModelMapper modelMappper;

    private final ActorQueryService actorQueryService;

    @Autowired
    public ActorActorResponseCreateMapper(ModelMapper modelMappper,
                                          ActorQueryService actorQueryService) {
        this.modelMappper = modelMappper;
        this.actorQueryService = actorQueryService;
    }

    @Override
    public ActorResponse map(Actor from) {

        final ActorResponse response = modelMappper.map(from, ActorResponse.class);

        return response;
    }
}
