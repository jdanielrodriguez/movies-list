package com.experto.cleverpyapplication.model;

public class ListItemModel {
   private int id;
   private boolean adult;
   private String backdrop_path;
   private String original_language;
   private String original_title;
   private String overview;
   private Long popularity;
   private String poster_path;
   private String release_date;
   private String title;
   private boolean video;
   private Long vote_average;
   private Long vote_count;

   public boolean isAdult() {
      return this.adult;
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

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public boolean getAdult() {
      return adult;
   }

   public void setAdult(boolean adult) {
      this.adult = adult;
   }
}