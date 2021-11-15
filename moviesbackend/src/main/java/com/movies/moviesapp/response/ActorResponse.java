package com.movies.moviesapp.response;

public class ActorResponse {

    /**
     * Actor ID.
     */
    private Long id;

    /**
     * Actor name.
     */
    private String actorName;

    /**
     * Actor surname.
     */
    private String actorSurname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorSurname() {
        return actorSurname;
    }

    public void setActorSurname(String actorSurname) {
        this.actorSurname = actorSurname;
    }
}
