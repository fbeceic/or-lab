package com.movies.moviesapp.exception;

import org.springframework.http.HttpStatus;

public class ApiException {

    private final HttpStatus status;

    private final String message;

    private final String response;

    public ApiException(HttpStatus status, String message, String response) {
        this.status = status;
        this.message = message;
        this.response = response;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getResponse() {
        return response;
    }
}
