package com.movies.moviesapp.controller.response;

import com.movies.moviesapp.entity.Movie;

import java.util.List;

public class WrappedMovieListResponse {
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
    private List<Movie> response;

    public WrappedMovieListResponse(String status, String message, List<Movie> response) {
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

    public List<Movie> getResponse() {
        return response;
    }

    public void setResponse(List<Movie> response) {
        this.response = response;
    }
}
