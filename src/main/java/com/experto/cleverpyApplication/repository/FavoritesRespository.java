package com.experto.cleverpyapplication.repository;

import com.experto.cleverpyapplication.model.Favorite;
import com.experto.cleverpyapplication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRespository extends JpaRepository<Favorite, Long> {
  Favorite[] findByUserId(Long userId);
  Favorite[] findByMovieId(Long movieId);
}
