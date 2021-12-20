package com.movies.moviesapp.service.impl;

import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.entity.Director;
import com.movies.moviesapp.repository.ActorRepository;
import com.movies.moviesapp.repository.DirectorRepository;
import com.movies.moviesapp.service.ActorQueryService;
import com.movies.moviesapp.service.DirectorQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorQueryServiceImpl implements DirectorQueryService {

    private final DirectorRepository directorRepository;

    public DirectorQueryServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }


    @Override
    public List<Director> findAll() {
        return directorRepository.findAll();
    }

}
