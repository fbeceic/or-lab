package com.movies.moviesapp.entity;

import ioinformarics.oss.jackson.module.jsonld.annotation.*;

import javax.persistence.*;

@Entity
@Table(name = "actor")
@JsonldResource
@JsonldType("http://schema.org/Person")
public class Actor {

    @Id
    @Column(name = "id")
    private Long id;

    @JsonldProperty("http://schema.org/name")
    @Column(name = "actorname")
    private String name;

    @JsonldProperty("http://schema.org/surname")
    @Column(name = "actorsurname")
    private String surname;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
