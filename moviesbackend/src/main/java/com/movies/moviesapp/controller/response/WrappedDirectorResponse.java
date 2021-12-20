package com.movies.moviesapp.controller.response;

import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.entity.Director;
import org.springframework.ui.Model;

public class WrappedDirectorResponse {

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
    private Director response;

    public WrappedDirectorResponse(String status, String message, Director response) {
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

    public Director getResponse() {
        return response;
    }

    public void setResponse(Director response) {
        this.response = response;
    }
}
