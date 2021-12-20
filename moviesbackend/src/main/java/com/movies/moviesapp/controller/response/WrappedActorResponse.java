package com.movies.moviesapp.controller.response;

import com.movies.moviesapp.entity.Actor;

public class WrappedActorResponse {

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
    private Actor response;

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

    public Actor getResponse() {
        return response;
    }

    public void setResponse(Actor response) {
        this.response = response;
    }
}
