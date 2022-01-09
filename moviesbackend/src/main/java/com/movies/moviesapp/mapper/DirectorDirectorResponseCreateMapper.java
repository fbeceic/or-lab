package com.movies.moviesapp.mapper;

import com.movies.moviesapp.controller.response.DirectorResponse;
import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.entity.Director;
import com.movies.moviesapp.controller.response.ActorResponse;
import com.movies.moviesapp.service.ActorQueryService;
import com.movies.moviesapp.util.mapper.CreateMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectorDirectorResponseCreateMapper implements CreateMapper<Director, DirectorResponse> {

    private final ModelMapper modelMapper;

    @Autowired
    public DirectorDirectorResponseCreateMapper(ModelMapper modelMappper) {
        this.modelMapper = modelMappper;
    }

    @Override
    public DirectorResponse map(Director from) {

        final DirectorResponse response = modelMapper.map(from, DirectorResponse.class);

        return response;
    }
}
