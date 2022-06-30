package com.experto.cleverpyapplication;

import com.experto.cleverpyapplication.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CleverpyApplication {

  public static void main(String[] args) {
    SpringApplication.run(CleverpyApplication.class, args);
  }

  @EnableWebSecurity
  @Configuration
  class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .csrf()
        .disable()
        .addFilterAfter(
          new JWTAuthorizationFilter(),
          UsernamePasswordAuthenticationFilter.class
        )
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/login")
        .permitAll()
        .anyRequest()
        .authenticated();
    }
  }

  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
