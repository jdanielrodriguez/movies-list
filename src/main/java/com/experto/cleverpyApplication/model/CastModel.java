package com.experto.cleverpyapplication.model;

public class CastModel {

  private Long id;

  private boolean adult;
  private int gender;
  private String known_for_department;
  private String name;
  private String original_name;
  private Long popularity;
  private String profile_path;
  private int cast_id;
  private String character;
  private String credit_id;
  private int order;

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

  public int getGender() {
    return this.gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getKnown_for_department() {
    return this.known_for_department;
  }

  public void setKnown_for_department(String known_for_department) {
    this.known_for_department = known_for_department;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOriginal_name() {
    return this.original_name;
  }

  public void setOriginal_name(String original_name) {
    this.original_name = original_name;
  }

  public Long getPopularity() {
    return this.popularity;
  }

  public void setPopularity(Long popularity) {
    this.popularity = popularity;
  }

  public String getProfile_path() {
    return this.profile_path;
  }

  public void setProfile_path(String profile_path) {
    this.profile_path = profile_path;
  }

  public int getCast_id() {
    return this.cast_id;
  }

  public void setCast_id(int cast_id) {
    this.cast_id = cast_id;
  }

  public String getCharacter() {
    return this.character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }

  public String getCredit_id() {
    return this.credit_id;
  }

  public void setCredit_id(String credit_id) {
    this.credit_id = credit_id;
  }

  public int getOrder() {
    return this.order;
  }

  public void setOrder(int order) {
    this.order = order;
  }
}
