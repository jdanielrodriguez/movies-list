package com.experto.cleverpyapplication.controller;

import com.experto.cleverpyapplication.model.UserModel;
import com.experto.cleverpyapplication.repository.UserRespository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UsersController {

  private UserRespository userRespository;

  private String secret = "secret";

  private int strength = 10;

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
  ResponseEntity<UserModel> login(@RequestBody UserModel authProf) {
    UserModel user = userRespository.findByUsername(authProf.getUsername());
    if (user == null) {
      return ResponseEntity.notFound().build();
    }
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(
      strength,
      new SecureRandom()
    );
    boolean isPasswordMatch = bCryptPasswordEncoder.matches(
      authProf.getPassword(),
      user.getPassword()
    );
    if (!isPasswordMatch) {
      return ResponseEntity.badRequest().build();
    }
    String token = getJWTToken(authProf.getUsername());
    user.setUsername(authProf.getUsername());
    user.setToken(token);
    user.setLast_conection(getLastConnection());
    return ResponseEntity.ok(user);
  }

  @PostMapping("/signup")
  ResponseEntity<UserModel> signup(@RequestBody UserModel payload) {
    // Generate token here
    if (payload.getEmail() == null || payload.getEmail() == "") {
      return ResponseEntity.badRequest().build();
    }

    UserModel user = new UserModel();
    user.setUsername(payload.getEmail().split("@", 5)[0]);
    String token = getJWTToken(user.getUsername());
    user.setToken(token);
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(
      strength,
      new SecureRandom()
    );
    String encodedPassword = bCryptPasswordEncoder.encode(
      payload.getPassword()
    );
    user.setPassword(encodedPassword);
    user.setEmail(payload.getEmail());
    user.setLast_conection(getLastConnection());

    return ResponseEntity.ok(userRespository.save(user));
  }

  @PostMapping("/gettoken")
  ResponseEntity<String> signup(@RequestParam long userId) {
    UserModel user = userRespository.findById(userId).orElse(null);
    if (user == null) {
      return ResponseEntity.notFound().build();
    }
    String token = getJWTToken(user.getUsername());
    return ResponseEntity.ok(token);
  }

  private String getLastConnection() {
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String strDate = dateFormat.format(date);
    return strDate;
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
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + (43200 * 1000)))
      .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
      .compact();

    return "Bearer " + token;
  }
}
