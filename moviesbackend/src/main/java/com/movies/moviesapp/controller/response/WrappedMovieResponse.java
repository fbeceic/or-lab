package com.movies.moviesapp.controller.response;

import com.movies.moviesapp.entity.Movie;

import java.util.List;

public class WrappedMovieResponse {
    /**
     * Status of the response.
     */
    private String status;

    /**
     * Message of the response
     */
    private String message;

    /**
     * The response itself.
     */
    private Movie response;

    public WrappedMovieResponse(String status, String message, Movie response) {
        this.status = status;
        this.message = message;
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Movie getResponse() {
        return response;
    }

    public void setResponse(Movie response) {
        this.response = response;
    }
}
