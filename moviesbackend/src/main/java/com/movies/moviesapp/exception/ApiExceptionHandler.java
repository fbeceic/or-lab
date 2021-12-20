package com.movies.moviesapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e ) {

        HttpStatus notFound = HttpStatus.NOT_FOUND;

        HttpStatus notOwned = HttpStatus.METHOD_NOT_ALLOWED;

        if (e.getMessage().equals("MOVIES")) {
            ApiException apiException = new ApiException(
                    notOwned,
                    "Wrong inquiry",
                    null);
            return new ResponseEntity<>(apiException, notFound);
        }

        if (e.getMessage().equals("MOVIES_PUT")) {
            ApiException apiException = new ApiException(
                    notOwned,
                    "Method not allowed for requested resource",
                    null);
            return new ResponseEntity<>(apiException, notFound);
        }

        if (e.getMessage().equals("ACTOR_ID")) {
            ApiException apiException = new ApiException(
                    notFound,
                    "Actor with the provided ID doesn't exist",
                    null);
            return new ResponseEntity<>(apiException, notFound);
        }

        if (e.getMessage().equals("ACTOR_NAME")) {
            ApiException apiException = new ApiException(
                    notFound,
                    "Actor with the provided name doesn't exist",
                    null);
            return new ResponseEntity<>(apiException, notFound);
        }

        if (e.getMessage().equals("DIRECTOR")) {
            ApiException apiException = new ApiException(
                    notFound,
                    "No directors are in the database",
                    null);
            return new ResponseEntity<>(apiException, notFound);
        }


        if (e.getMessage().equals("DIRECTOR_ID")) {
            ApiException apiException = new ApiException(
                    notFound,
                    "Director with the provided ID doesn't exist",
                    null);
            return new ResponseEntity<>(apiException, notFound);
        }

        if (e.getMessage().equals("GENRE")) {
            ApiException apiException = new ApiException(
                    notFound,
                    "Movie of the provided genre doesn't exist",
                    null);
            return new ResponseEntity<>(apiException, notFound);
        }

        if (e.getMessage().equals("IMDB")) {
            ApiException apiException = new ApiException(
                    notFound,
                    "Movie with the provided IMDb rating doesn't exist",
                    null);
            return new ResponseEntity<>(apiException, notFound);
        }

        if (e.getMessage().equals("EDIT_MOVIE")) {
            ApiException apiException = new ApiException(
                    notFound,
                    "The movie with the desired ID doesn't exist",
                    null);
            return new ResponseEntity<>(apiException, notFound);
        }

        return null;
    }

}
