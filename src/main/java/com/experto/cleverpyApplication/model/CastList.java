package com.experto.cleverpyapplication.model;

public class CastList {

  private Long id;

  private CastModel[] cast;
  private CastModel[] crew;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CastModel[] getCast() {
    return this.cast;
  }

  public void setCast(CastModel[] cast) {
    this.cast = cast;
  }

  public CastModel[] getCrew() {
    return this.crew;
  }

  public void setCrew(CastModel[] crew) {
    this.crew = crew;
  }
}
