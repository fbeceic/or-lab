package com.movies.moviesapp.entity;

import ioinformarics.oss.jackson.module.jsonld.annotation.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
@JsonldResource
@JsonldType("http://schema.org/Movie")
public class Movie {

    @Id
    @Column(name = "id")
    private Long id;

    @JsonldProperty("http://schema.org/name")
    @Column(name = "name")
    private String name;

    @JsonldProperty("http://schema.org/countryOfOrigin")
    @Column(name = "country")
    private String country;

    @Column(name = "year")
    private Integer year;

    @JsonldProperty("http://schema.org/duration")
    @Column(name = "duration_min")
    private Integer duration;

    @JsonldProperty("http://schema.org/genre")
    @Column(name = "genre1")
    private String genre1;

    @JsonldProperty("http://schema.org/genre")
    @Column(name = "genre2")
    private String genre2;

    @JsonldProperty("http://schema.org/director")
    @ManyToOne
    @JoinColumn(name = "directorid")
    private Director director;

    @JsonldProperty("http://schema.org/actor")
    @ManyToMany
    @JoinTable(name = "casting",
            joinColumns = @JoinColumn(name = "movieid"),
            inverseJoinColumns = @JoinColumn(name = "actorid"))
    private List<Actor> actors;

    @JsonldProperty("http://schema.org/contentRating")
    @Column(name = "mparating")
    private String mparating;

    @Column(name = "budget_$")
    private Integer budget;

    @Column(name = "gross_$")
    private Integer gross;

    @Column(name = "ratingimdb")
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

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
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

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
