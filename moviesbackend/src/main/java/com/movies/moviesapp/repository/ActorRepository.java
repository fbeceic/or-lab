package com.movies.moviesapp.repository;

import com.movies.moviesapp.entity.Actor;
import com.movies.moviesapp.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>, JpaSpecificationExecutor<Actor> {

    boolean existsById(Long id);

    Optional<Actor> findById(Long id);

    List<Actor> findByNameContaining(String name);

    List<Actor> findBySurnameContaining(String surname);

    List<Actor> findByNameContainingOrSurnameContaining(String name, String surname);


}
