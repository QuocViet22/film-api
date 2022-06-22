package com.springboot.api.controller;

import com.springboot.api.exception.ResourceNotFoundException;
import com.springboot.api.model.Actor;
import com.springboot.api.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/actors")
public class ActorController {
    @Autowired
    private ActorRepository actorRepository;

//    @GetMapping
//    public List<Actor> getAllActors() {
//        return actorRepository.findAll();
//    }

    // get all actors

    @GetMapping
    public Page<Actor> actorsPageable(Pageable pageable) {
        return actorRepository.findAll(pageable);
    }

    // build create actor REST API
    @PostMapping
    public Actor createActor(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    // build get actor by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id:" + id));
        return ResponseEntity.ok(actor);
    }


    //Find by type
    @GetMapping("/gender")
    public ResponseEntity<List<Actor>> getActorByName(@RequestParam String type) {
        return new ResponseEntity<List<Actor>>(actorRepository.findByGender(type), HttpStatus.OK);
    }

    // build update actor REST API
    @PutMapping("{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable long id, @RequestBody Actor actorDetails) {
        Actor updateActor = actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + id));
        updateActor.setName(actorDetails.getName());
        updateActor.setGender(actorDetails.getGender());
        updateActor.setAge(actorDetails.getAge());
        updateActor.setEyeColor(actorDetails.getEyeColor());
        updateActor.setHairColor(actorDetails.getHairColor());
        updateActor.setStatus(actorDetails.getStatus());
        updateActor.setUrl(actorDetails.getUrl());
        actorRepository.save(updateActor);
        return ResponseEntity.ok(updateActor);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteActor(@PathVariable long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actor not exist with id: " + id));
        actorRepository.delete(actor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
