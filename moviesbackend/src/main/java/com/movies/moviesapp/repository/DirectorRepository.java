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
public interface DirectorRepository extends JpaRepository<Director, Long>, JpaSpecificationExecutor<Director> {

    List<Director> findAll();

    Optional<Director> findById(Long id);

    List<Director> findByNameContainingOrSurnameContaining(String name, String surname);

}
