package com.movies.moviesapp.controller;

import com.movies.moviesapp.controller.response.WrappedActorListResponse;
import com.movies.moviesapp.controller.response.WrappedDirectorListResponse;
import com.movies.moviesapp.controller.response.WrappedDirectorResponse;
import com.movies.moviesapp.exception.ApiRequestException;
import com.movies.moviesapp.controller.response.DirectorResponse;
import com.movies.moviesapp.entity.Director;
import com.movies.moviesapp.repository.DirectorRepository;
import com.movies.moviesapp.util.mapper.CreateMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    private final DirectorRepository directorRepository;

    private final CreateMapper<Director, DirectorResponse> directorDirectorResponseCreateMapper;

    public DirectorController(DirectorRepository directorRepository, CreateMapper<Director, DirectorResponse> directorDirectorResponseCreateMapper) {
        this.directorRepository = directorRepository;
        this.directorDirectorResponseCreateMapper = directorDirectorResponseCreateMapper;
    }

    /**
     * Returns all directors.
     *
     * @return List of all directors
     */
    @GetMapping //localhost:9090/directors
    @ResponseStatus(HttpStatus.OK)
    public WrappedDirectorListResponse findAllDirectors() {
        final List<Director> directors = directorRepository.findAll();

        if(!directors.isEmpty()) {
            return new WrappedDirectorListResponse("OK","Fetched all directors", directors);
        } else {
            throw new ApiRequestException("DIRECTOR");
        }

    }

    /**
     * Returns a director by ID.
     * @param id Request describing the director of the movie
     * @return Director with the specified ID
     */
    @GetMapping ("/id/{id}") //localhost:9090/directors
    @ResponseStatus(HttpStatus.OK)
    public WrappedDirectorResponse findDirectorsById(@PathVariable Long id) {

        final Optional<Director> director = directorRepository.findById(id);

        if (director.isPresent()) {

            return new WrappedDirectorResponse("OK","Fetched director with desired ID", director.get());

        } else {

            throw new ApiRequestException("DIRECTOR_ID");
        }
    }
}
