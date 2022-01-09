package com.movies.moviesapp.mapper;

import com.movies.moviesapp.controller.response.DirectorResponse;
import com.movies.moviesapp.controller.response.MovieResponse;
import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.entity.Director;
import com.movies.moviesapp.entity.Movie;
import com.movies.moviesapp.controller.response.ActorResponse;
import com.movies.moviesapp.util.mapper.CreateMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMovieResponseCreateMapper implements CreateMapper<Movie, MovieResponse> {

    private final ModelMapper modelMapper;

    private final CreateMapper<Actor, ActorResponse> actorActorResponseCreateMapper;

    private final CreateMapper<Director, DirectorResponse> directorDirectorResponseCreateMapper;

    @Autowired
    public MovieMovieResponseCreateMapper(ModelMapper modelMapper, CreateMapper<Actor, ActorResponse> actorActorResponseCreateMapper, CreateMapper<Director, DirectorResponse> directorDirectorResponseCreateMapper) {
        this.modelMapper = modelMapper;
        this.actorActorResponseCreateMapper = actorActorResponseCreateMapper;
        this.directorDirectorResponseCreateMapper = directorDirectorResponseCreateMapper;
    }

    @Override
    public MovieResponse map(Movie from) {

        final MovieResponse response = modelMapper.map(from, MovieResponse.class);

        final List<ActorResponse> actors = actorActorResponseCreateMapper.mapToList(from.getActors());

        final DirectorResponse director = directorDirectorResponseCreateMapper.map(from.getDirector());

        response.setGenres(from.getGenre1()+", "+from.getGenre2());
        response.setActors(actors);
        response.setDirector(director);

        return response;
    }
}
