package com.experto.cleverpyapplication.model;

public class CastMoviesList {

  private Long id;

  private Movies[] cast;
  private Movies[] crew;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Movies[] getCast() {
    return this.cast;
  }

  public void setCast(Movies[] cast) {
    this.cast = cast;
  }

  public Movies[] getCrew() {
    return this.crew;
  }

  public void setCrew(Movies[] crew) {
    this.crew = crew;
  }
}
