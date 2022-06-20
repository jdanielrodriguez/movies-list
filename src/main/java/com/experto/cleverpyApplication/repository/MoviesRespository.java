package com.experto.cleverpyapplication.repository;

import com.experto.cleverpyapplication.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRespository extends JpaRepository<MovieModel, Long> {
}
