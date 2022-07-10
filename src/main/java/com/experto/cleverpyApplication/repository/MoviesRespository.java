package com.experto.cleverpyapplication.repository;

import com.experto.cleverpyapplication.model.Movies;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.*;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRespository extends JpaRepository<Movies, Long> {
  @Nullable
  Optional<Movies> findById(Long id);
}
