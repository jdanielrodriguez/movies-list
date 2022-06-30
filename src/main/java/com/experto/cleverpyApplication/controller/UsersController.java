package com.experto.cleverpyapplication.controller;

import com.experto.cleverpyapplication.model.UserModel;
import com.experto.cleverpyapplication.repository.UserRespository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

class AuthProfile {

  String username;
  String pwd;

  public AuthProfile() {}

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPwd() {
    return this.pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
}

@RestController
public class UsersController {

  private UserRespository userRespository;

  private String secret = "secret";

  @Autowired
  public UsersController(UserRespository userRespository) {
    this.userRespository = userRespository;
  }

  @GetMapping("/users")
  Iterable<UserModel> all() {
    return userRespository.findAll();
  }

  @GetMapping("/users/{id}")
  UserModel userById(@PathVariable Long id) {
    return userRespository
      .findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/login")
  public UserModel login(@RequestBody AuthProfile authProf) {
    String token = getJWTToken(authProf.getUsername());
    UserModel user = new UserModel();
    user.setUsername(authProf.getUsername());
    user.setToken(token);
    return user;
  }

  private String getJWTToken(String username) {
    String secretKey = "" + secret;
    List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(
      "ROLE_USER"
    );

    String token = Jwts
      .builder()
      .setId("softtekJWT")
      .setSubject(username)
      .claim(
        "authorities",
        grantedAuthorities
          .stream()
          .map(GrantedAuthority::getAuthority)
          .collect(Collectors.toList())
      )
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + (43200 * 1000)))
      .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
      .compact();

    return "Bearer " + token;
  }

  @PostMapping("/signup")
  UserModel signup(@RequestBody UserModel user) {
    // Generate token here
    return userRespository.save(user);
  }
}
