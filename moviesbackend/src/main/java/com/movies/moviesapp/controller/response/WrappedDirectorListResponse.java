package com.movies.moviesapp.controller.response;

import com.movies.moviesapp.entity.Director;

import java.util.List;

public class WrappedDirectorListResponse {

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
    private List<Director> response;

    public WrappedDirectorListResponse(String status, String message, List<Director> response) {
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

    public List<Director> getResponse() {
        return response;
    }

    public void setResponse(List<Director> response) {
        this.response = response;
    }
}
