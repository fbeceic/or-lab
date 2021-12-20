package com.movies.moviesapp.controller.response;

import com.movies.moviesapp.entity.Director;

import java.util.List;

public class MovieResponse {

    /**
     * Movie id.
     */
    private Long id;

    /**
     * Movie name.
     */
    private String name;

    /**
     * Movie Country.
     */
    private String country;

    /**
     * Movie year.
     */
    private Integer year;

    /**
     * Movie duration.
     */
    private Integer duration;

    /**
     * Movie genres.
     */
    private String genres;

    /**
     * Movie director.
     */
    private DirectorResponse director;

    /**
     * Movie actors.
     */
    private List<ActorResponse> actors;

    /**
     * Movie MPA rating.
     */
    private String mparating;

    /**
     * Movie budget.
     */
    private Integer budget;

    /**
     * Movie worldwide gross.
     */
    private Integer gross;

    /**
     * Movie IMDb rating.
     */
    private Double rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public DirectorResponse getDirector() {
        return director;
    }

    public void setDirector(DirectorResponse director) {
        this.director = director;
    }

    public List<ActorResponse> getActors() {
        return actors;
    }

    public void setActors(List<ActorResponse> actors) {
        this.actors = actors;
    }

    public String getMparating() {
        return mparating;
    }

    public void setMparating(String mparating) {
        this.mparating = mparating;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getGross() {
        return gross;
    }

    public void setGross(Integer gross) {
        this.gross = gross;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
