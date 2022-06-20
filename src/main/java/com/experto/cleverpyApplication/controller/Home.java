package com.experto.cleverpyapplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/")
    public String home() {
        return "Hello Spring Boot with Docker for the Cleverpy technical test";
    }

}
