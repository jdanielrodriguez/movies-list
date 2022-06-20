package com.experto.cleverpyapplication.model;
public class MovieSummary {

   private String id;
   private String title;
   private String overview;

   private boolean adult;
   private String backdrop_path;
   private String belongs_to_collection;
   private int budget;
   private String homepage;
   private String imdb_id;
   private String original_language;
   private String original_title;
   private Long popularity;
   private String poster_path;
   private String release_date;
   private int revenue;
   private int runtime;
   private String status;
   private String tagline;
   private boolean video;
   private Long vote_average;
   private Long vote_count;

   public boolean isAdult() {
      return this.adult;
   }

   public boolean getAdult() {
      return this.adult;
   }

   public void setAdult(boolean adult) {
      this.adult = adult;
   }

   public String getBackdropPath() {
      return this.backdrop_path;
   }

   public void setBackdropPath(String backdrop_path) {
      this.backdrop_path = backdrop_path;
   }

   public String getBelongsToCollection() {
      return this.belongs_to_collection;
   }

   public void setBelongsToCollection(String belongs_to_collection) {
      this.belongs_to_collection = belongs_to_collection;
   }

   public int getBudget() {
      return this.budget;
   }

   public void setBudget(int budget) {
      this.budget = budget;
   }

   public String getHomepage() {
      return this.homepage;
   }

   public void setHomepage(String homepage) {
      this.homepage = homepage;
   }

   public String getImdbId() {
      return this.imdb_id;
   }

   public void setImdbId(String imdb_id) {
      this.imdb_id = imdb_id;
   }

   public String getOriginalLanguage() {
      return this.original_language;
   }

   public void setOriginalLanguage(String original_language) {
      this.original_language = original_language;
   }

   public String getOriginalTitle() {
      return this.original_title;
   }

   public void setOriginalTitle(String original_title) {
      this.original_title = original_title;
   }

   public Long getPopularity() {
      return this.popularity;
   }

   public void setPopularity(Long popularity) {
      this.popularity = popularity;
   }

   public String getPosterPath() {
      return this.poster_path;
   }

   public void setPosterPath(String poster_path) {
      this.poster_path = poster_path;
   }

   public String getReleaseDate() {
      return this.release_date;
   }

   public void setReleaseDate(String release_date) {
      this.release_date = release_date;
   }

   public int getRevenue() {
      return this.revenue;
   }

   public void setRevenue(int revenue) {
      this.revenue = revenue;
   }

   public int getRuntime() {
      return this.runtime;
   }

   public void setRuntime(int runtime) {
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

   public Long getVoteAverage() {
      return this.vote_average;
   }

   public void setVoteAverage(Long vote_average) {
      this.vote_average = vote_average;
   }

   public Long getVoteCount() {
      return this.vote_count;
   }

   public void setVoteCount(Long vote_count) {
      this.vote_count = vote_count;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getOverview() {
      return overview;
   }

   public void setOverview(String overview) {
      this.overview = overview;
   }
}