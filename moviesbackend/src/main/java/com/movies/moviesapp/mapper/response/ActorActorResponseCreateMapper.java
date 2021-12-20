package com.movies.moviesapp.mapper.response;

import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.controller.response.ActorResponse;
import com.movies.moviesapp.util.mapper.CreateMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActorActorResponseCreateMapper implements CreateMapper<Actor, ActorResponse> {

    private final ModelMapper modelMapper;

    @Autowired
    public ActorActorResponseCreateMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ActorResponse map(Actor from) {

        final ActorResponse response = modelMapper.map(from, ActorResponse.class);

        return response;
    }
}
