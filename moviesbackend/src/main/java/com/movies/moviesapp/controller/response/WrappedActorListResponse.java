package com.movies.moviesapp.controller.response;

import com.movies.moviesapp.entity.Actor;

import java.util.List;

public class WrappedActorListResponse {

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
    private List<Actor> response;

    public WrappedActorListResponse(String status, String message, List<Actor> response) {
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

    public List<Actor> getResponse() {
        return response;
    }

    public void setResponse(List<Actor> response) {
        this.response = response;
    }
}
