package com.movies.moviesapp.entity;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;

import javax.persistence.*;

@Entity
@Table(name = "director")
@JsonldResource
@JsonldType("http://schema.org/Person")
public class Director {

    @Id
    @Column(name = "id")
    private Long id;

    @JsonldProperty("http://schema.org/name")
    @Column(name = "directorname")
    private String name;

    @JsonldProperty("http://schema.org/surname")
    @Column(name = "directorsurname")
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
