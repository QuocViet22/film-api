package com.springboot.api.controller;

import com.springboot.api.exception.ResourceNotFoundException;

import com.springboot.api.model.Film;
import com.springboot.api.repository.FilmRepository;
//import com.springboot.api.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/films")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;
//    private WorkRepository workRepository;

    // get all films
    @GetMapping
    public Page<Film> actorsPageable(Pageable pageable) {
        return filmRepository.findAll(pageable);
    }

//    public List<Film> getAllUsers() {
//        Film film = new Film();
//        List<Film> filmList = filmRepository.findAll();
//        return filmList;
//    }


    // build create film REST API
    @PostMapping
    public Film createActor(@RequestBody Film film) {
        return filmRepository.save(film);
    }

    // build get film by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable long id) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Film not exist with id:" + id));
        return ResponseEntity.ok(film);
    }

    // build update film REST API
    @PutMapping("{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable long id, @RequestBody Film filmDetails) {
        Film updateFilm = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Film not exist with id: " + id));
        updateFilm.setTitle(filmDetails.getTitle());
        updateFilm.setOriginalTitle(filmDetails.getOriginalTitle());
        updateFilm.setOriginalTitleRomanised(filmDetails.getOriginalTitleRomanised());
        updateFilm.setImage(filmDetails.getImage());
        updateFilm.setMovieBanner(filmDetails.getMovieBanner());
        updateFilm.setDescription(filmDetails.getDescription());
        updateFilm.setDirector(filmDetails.getDirector());
        updateFilm.setProducer(filmDetails.getProducer());
        updateFilm.setReleaseDate(filmDetails.getReleaseDate());
        updateFilm.setRunningTime(filmDetails.getRunningTime());
        updateFilm.setRtScore(filmDetails.getRtScore());
        updateFilm.setStatus(filmDetails.getStatus());
        updateFilm.setUrl(filmDetails.getUrl());
        filmRepository.save(updateFilm);
        return ResponseEntity.ok(updateFilm);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteFilm(@PathVariable long id) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + id));
        filmRepository.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
