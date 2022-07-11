package com.experto.cleverpyapplication.model;

public class MovieSummary {

  private String id;
  private String title;
  private String overview;

  private boolean adult;
  private String backdrop_path;
  private Long budget;
  private String homepage;
  private String imdb_id;
  private String original_language;
  private String original_title;
  private Long popularity;
  private String poster_path;
  private String release_date;
  private Long revenue;
  private Long runtime;
  private String status;
  private String tagline;
  private boolean video;
  private Long vote_average;
  private Long vote_count;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getOverview() {
    return this.overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
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

  public Long getBudget() {
    return this.budget;
  }

  public void setBudget(Long budget) {
    this.budget = budget;
  }

  public String getHomepage() {
    return this.homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public String getImdb_id() {
    return this.imdb_id;
  }

  public void setImdb_id(String imdb_id) {
    this.imdb_id = imdb_id;
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

  public Long getRevenue() {
    return this.revenue;
  }

  public void setRevenue(Long revenue) {
    this.revenue = revenue;
  }

  public Long getRuntime() {
    return this.runtime;
  }

  public void setRuntime(Long runtime) {
    this.runtime = runtime;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTagline() {
    return this.tagline;
  }

  public void setTagline(String tagline) {
    this.tagline = tagline;
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
