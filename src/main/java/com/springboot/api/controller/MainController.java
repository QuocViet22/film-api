package com.springboot.api.controller;

import com.springboot.api.model.Main;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class MainController {

    private String userPath = "http://localhost:8080/api/v1/users";
    private String filmsPath = "http://localhost:8080/api/v1/films";
    //    view main page
    @GetMapping
    public Main view() {
        Main main = new Main();
        main.setAuthor("Hoang Quoc Viet");
        main.setLastUpdate("21-06-2022");
        main.setUser(userPath);
        main.setFilms(filmsPath);
        return main;
    }
}

