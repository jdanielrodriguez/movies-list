package com.experto.cleverpyapplication.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Movies {

  @Id
  private Long id;

  @Column(nullable = true)
  private boolean adult;

  @Column(nullable = true)
  private String backdrop_path;

  @Column(nullable = true)
  private String original_language;

  @Column(nullable = true, columnDefinition = "TEXT")
  private String original_title;

  @Column(columnDefinition = "TEXT")
  @NotNull
  private String overview;

  @Column(nullable = true)
  private Long popularity;

  @Column(nullable = true)
  private String poster_path;

  @Column(nullable = true)
  private String release_date;

  @Column(nullable = true, columnDefinition = "TEXT")
  private String title;

  @Column(nullable = true)
  private boolean video;

  @Column(nullable = true)
  private Long vote_average;

  @Column(nullable = true)
  private Long vote_count;

  public Movies() {}

  public Movies(MovieSummary summary) {
    this.adult = summary.getAdult();
    this.backdrop_path = summary.getBackdrop_path();
    this.id = Long.parseLong(summary.getId());
    this.original_language = summary.getOriginal_language();
    this.original_title = summary.getOriginal_title();
    this.overview = summary.getOverview();
    this.popularity = summary.getPopularity();
    this.poster_path = summary.getPoster_path();
    this.release_date = summary.getRelease_date();
    this.title = summary.getTitle();
    this.video = summary.getVideo();
    this.vote_average = summary.getVote_average();
    this.vote_count = summary.getVote_count();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isAdult() {
    return this.adult;
  }

  public boolean getAdult() {
    return this.adult;
  }

  public void setAdult(boolean adult) {
    this.adult = adult;
  }

  public String getBackdrop_path() {
    return this.backdrop_path;
  }

  public void setBackdrop_path(String backdrop_path) {
    this.backdrop_path = backdrop_path;
  }

  public String getOriginal_language() {
    return this.original_language;
  }

  public void setOriginal_language(String original_language) {
    this.original_language = original_language;
  }

  public String getOriginal_title() {
    return this.original_title;
  }

  public void setOriginal_title(String original_title) {
    this.original_title = original_title;
  }

  public String getOverview() {
    return this.overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public Long getPopularity() {
    return this.popularity;
  }

  public void setPopularity(Long popularity) {
    this.popularity = popularity;
  }

  public String getPoster_path() {
    return this.poster_path;
  }

  public void setPoster_path(String poster_path) {
    this.poster_path = poster_path;
  }

  public String getRelease_date() {
    return this.release_date;
  }

  public void setRelease_date(String release_date) {
    this.release_date = release_date;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isVideo() {
    return this.video;
  }

  public boolean getVideo() {
    return this.video;
  }

  public void setVideo(boolean video) {
    this.video = video;
  }

  public Long getVote_average() {
    return this.vote_average;
  }

  public void setVote_average(Long vote_average) {
    this.vote_average = vote_average;
  }

  public Long getVote_count() {
    return this.vote_count;
  }

  public void setVote_count(Long vote_count) {
    this.vote_count = vote_count;
  }
}
