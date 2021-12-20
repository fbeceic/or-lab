package com.movies.moviesapp.mapper.response;

import com.movies.moviesapp.controller.response.WrappedActorResponse;
import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.util.mapper.CreateMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActorWrappedActorResponseCreateMapper implements CreateMapper<Actor, WrappedActorResponse> {

    private final ModelMapper modelMapper;

    @Autowired
    public ActorWrappedActorResponseCreateMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public WrappedActorResponse map(Actor from) {

        final WrappedActorResponse response = modelMapper.map(from, WrappedActorResponse.class);

        response.setStatus("OK");
        response.setMessage("Fetched actor object");
        response.setResponse(from);

        return response;
    }
}