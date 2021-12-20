package com.movies.moviesapp.mapper.response;

import com.movies.moviesapp.controller.response.WrappedActorListResponse;
import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.util.mapper.CreateMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorListWrappedActorListResponseCreateMapper implements CreateMapper<List<Actor>, WrappedActorListResponse> {

    private final ModelMapper modelMapper;

    @Autowired
    public ActorListWrappedActorListResponseCreateMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public WrappedActorListResponse map(List<Actor> from) {


        final WrappedActorListResponse response = new WrappedActorListResponse("OK","Fetched actors", from);

        from.forEach(System.out::println);

        return response;
    }

}
