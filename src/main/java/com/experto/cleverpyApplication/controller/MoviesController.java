package com.experto.cleverpyapplication.controller;

import com.experto.cleverpyapplication.model.CastList;
import com.experto.cleverpyapplication.model.CastMoviesList;
import com.experto.cleverpyapplication.model.Favorite;
import com.experto.cleverpyapplication.model.FavoritesMovies;
import com.experto.cleverpyapplication.model.ListModel;
import com.experto.cleverpyapplication.model.MovieSummary;
import com.experto.cleverpyapplication.model.Movies;
import com.experto.cleverpyapplication.model.UserModel;
import com.experto.cleverpyapplication.repository.FavoritesRespository;
import com.experto.cleverpyapplication.repository.MoviesRespository;
import com.experto.cleverpyapplication.repository.UserRespository;
import com.experto.cleverpyapplication.security.JWTAuthorizationFilter;
import java.util.*;
import java.util.stream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MoviesController {

  @Autowired
  private FavoritesRespository favoritesRespository;

  @Autowired
  private UserRespository userRespository;

  private MoviesRespository moviesRespository;

  @Value("${api.key}")
  private String apiKey;

  @Value("${api.url}")
  private String apiPath;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  public MoviesController(MoviesRespository moviesRespository) {
    this.moviesRespository = moviesRespository;
  }

  @GetMapping("/movies")
  List<Movies> getCatalog() {
    return moviesRespository.findAll();
  }

  @PostMapping("/movies")
  ResponseEntity<Movies> setMovie(@RequestBody Movies payload) {
    Movies movie = new Movies();
    try {
      movie = moviesRespository.findById(payload.getId()).orElseThrow(null);
    } catch (NullPointerException e) {
      movie = moviesRespository.save(payload);
    }
    return ResponseEntity.ok(moviesRespository.save(movie));
  }

  @GetMapping("/movies/{movieId}")
  Movies getSingleAndSave(@PathVariable String movieId) {
    MovieSummary movieSummary = restTemplate.getForObject(
      apiPath + "/movie/" + movieId + "?api_key=" + apiKey,
      MovieSummary.class
    );
    movieSummary.setId((movieId));
    Movies movie = new Movies(movieSummary);
    try {
      movie =
        moviesRespository.findById(Long.parseLong(movieId)).orElseThrow(null);
    } catch (NullPointerException e) {
      movie = moviesRespository.save(movie);
    }

    return movie;
  }

  @GetMapping("/movies/{movieId}/cast")
  CastList getCast(@PathVariable String movieId) {
    CastList movieSummary = restTemplate.getForObject(
      apiPath + "/movie/" + movieId + "/credits?api_key=" + apiKey,
      CastList.class
    );
    return (movieSummary);
  }

  @GetMapping("/cast/{castId}")
  CastMoviesList getSingleCast(@PathVariable String castId) {
    CastMoviesList movieSummary = restTemplate.getForObject(
      apiPath + "/person/" + castId + "/credits?api_key=" + apiKey,
      CastMoviesList.class
    );
    return (movieSummary);
  }

  @PostMapping("/favorites/{movieId}")
  ResponseEntity<Favorite> saveFavorite(
    Authentication authentication,
    @PathVariable String movieId
  ) {
    if (movieId == null || movieId == "") {
      return ResponseEntity.badRequest().build();
    }
    Favorite fav = new Favorite();
    UserModel tempUsr;
    try {
      tempUsr =
        userRespository
          .findById(Long.parseLong(getUserId(authentication)))
          .orElseThrow(null);
    } catch (NullPointerException e) {
      return ResponseEntity.badRequest().build();
    }

    fav.setUser(tempUsr);
    Movies movie;
    try {
      movie =
        moviesRespository.findById(Long.parseLong(movieId)).orElseThrow(null);
    } catch (NullPointerException e) {
      MovieSummary movieSummary = restTemplate.getForObject(
        apiPath + "/movie/" + movieId + "?api_key=" + apiKey,
        MovieSummary.class
      );
      movieSummary.setId(movieId);
      movie = new Movies(movieSummary);
      movie.setId(Long.parseLong(movieId));
      movie = moviesRespository.save(movie);
    }
    fav.setMovie(movie);
    Favorite[] favs = favoritesRespository.findByUserId(
      Long.parseLong(getUserId(authentication))
    );
    if (favs.length > 0) {
      List<Favorite> movFav = Arrays
        .stream(favs)
        .filter(f -> f.getMovie().getId() == Long.parseLong(movieId))
        .collect(Collectors.toList());
      if (movFav.size() > 0) {
        return ResponseEntity.ok(movFav.get(0));
      }
    }
    return ResponseEntity.ok(favoritesRespository.save(fav));
  }

  @GetMapping("/favorites")
  FavoritesMovies getFavorite(Authentication authentication) {
    Favorite[] favs = favoritesRespository.findByUserId(
      Long.parseLong(getUserId(authentication))
    );
    FavoritesMovies response = new FavoritesMovies();
    response.setResults(favs);
    return response;
  }

  private String getUserId(Authentication authentication) {
    if (authentication == null || authentication.getName() == null) {
      return "0";
    }
    UserModel user = userRespository.findByUsername(authentication.getName());
    if (user == null) {
      return "0";
    }
    return user.getId() + "";
  }
}
