package com.springboot.api.controller;

import com.springboot.api.exception.ResourceNotFoundException;

import com.springboot.api.model.Work;
import com.springboot.api.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/work")
public class WorkController {
    @Autowired
    private WorkRepository workRepository;

    // get all work
    @GetMapping
    public List<Work> getAllWork() {
        return workRepository.findAll();
    }


    // build create work REST API
    @PostMapping
    public Work createWork(@RequestBody Work film) {
        return workRepository.save(film);
    }

    // build get film by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Work> getWorkById(@PathVariable long id) {
        Work work = workRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Work not exist with id:" + id));
        return ResponseEntity.ok(work);
    }

    //Find by first name
    @GetMapping("/filmId")
    public ResponseEntity<List<Work>> getWorkByFilmId(@RequestParam String filmId) {
        return new ResponseEntity<List<Work>>(workRepository.findByFilmId(filmId), HttpStatus.OK);
    }

    //Find by first name
    @GetMapping("/actorId")
    public ResponseEntity<List<Work>> getWorkByActorId(@RequestParam String actorId) {
        return new ResponseEntity<List<Work>>(workRepository.findByActorId(actorId), HttpStatus.OK);
    }

    // build update work REST API
    @PutMapping("{id}")
    public ResponseEntity<Work> updateWork(@PathVariable long id, @RequestBody Work workDetails) {
        Work updateWork = workRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Work not exist with id: " + id));
        updateWork.setFilmId(workDetails.getFilmId());
        updateWork.setActorId(workDetails.getActorId());
        updateWork.setActorProfile(workDetails.getActorProfile());
        updateWork.setStatus(workDetails.getStatus());

        workRepository.save(updateWork);
        return ResponseEntity.ok(updateWork);
    }

    // build delete work REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteWork(@PathVariable long id) {
        Work work = workRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Work not exist with id: " + id));
        workRepository.delete(work);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

