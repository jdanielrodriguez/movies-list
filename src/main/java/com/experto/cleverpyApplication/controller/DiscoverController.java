package com.experto.cleverpyapplication.controller;

import com.experto.cleverpyapplication.model.ListModel;
import com.experto.cleverpyapplication.model.MovieSummary;
import com.experto.cleverpyapplication.model.Movies;
import com.experto.cleverpyapplication.repository.MoviesRespository;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DiscoverController {

  private MoviesRespository moviesRespository;

  @Value("${api.key}")
  private String apiKey;

  @Value("${api.url}")
  private String apiPath;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  public DiscoverController(MoviesRespository moviesRespository) {
    this.moviesRespository = moviesRespository;
  }

  @GetMapping("/discover/movies")
  ListModel getDiscover(
    @RequestParam(required = false) Integer page,
    @RequestParam(required = false) Boolean popularity,
    @RequestParam(required = false) Integer year_realese,
    @RequestParam(required = false) Boolean highest
  ) {
    String url = "";
    String params = "";
    if (popularity != null && popularity) {
      params = "&sort_by=popularity.desc";
    }
    if (highest != null && highest) {
      params = "&sort_by=vote_average.desc";
    }
    if (year_realese != null && year_realese > 0) {
      params = "&primary_release_year=" + year_realese;
    }
    if (page != null && page > 0) {
      params = "&page=" + page;
    }
    url = apiPath + "/discover/movie?api_key=" + apiKey + params;
    ListModel response = restTemplate.getForObject(url, ListModel.class);
    return response;
  }
}
