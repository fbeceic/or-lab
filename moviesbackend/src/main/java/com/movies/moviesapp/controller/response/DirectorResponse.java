package com.movies.moviesapp.controller.response;

public class DirectorResponse {

    /**
     * Director ID.
     */
    private Long id;

    /**
     * Director name.
     */
    private String name;

    /**
     * Director surname.
     */
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
