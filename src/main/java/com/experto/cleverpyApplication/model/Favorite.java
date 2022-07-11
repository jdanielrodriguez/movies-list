package com.experto.cleverpyapplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(
    optional = false,
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER
  )
  @JsonProperty(access = Access.WRITE_ONLY)
  private UserModel user;

  @ManyToOne(
    optional = false,
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER
  )
  private Movies movie;

  public UserModel getUser() {
    return this.user;
  }

  public void setUser(UserModel user) {
    this.user = user;
  }

  public Movies getMovie() {
    return this.movie;
  }

  public void setMovie(Movies movie) {
    this.movie = movie;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
