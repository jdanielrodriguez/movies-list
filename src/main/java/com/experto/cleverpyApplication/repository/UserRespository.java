package com.experto.cleverpyapplication.repository;

import com.experto.cleverpyapplication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<UserModel, Long> {
}
