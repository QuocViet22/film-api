package com.springboot.api.controller;

import com.springboot.api.exception.ResourceNotFoundException;
import com.springboot.api.model.User;
import com.springboot.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @GetMapping
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }

    //    get all user

    @GetMapping
    public Page<User> usersPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    // build create user REST API
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // build get user by id REST API
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        return ResponseEntity.ok(user);
    }

    //Find by first name
    @GetMapping("/firstName")
    public ResponseEntity<List<User>> getUserByFirstName(@RequestParam String firstName) {
        return new ResponseEntity<List<User>>(userRepository.findByFirstName(firstName), HttpStatus.OK);
    }

    //Find by last name
    @GetMapping("/lastName")
    public ResponseEntity<List<User>> getUserByLastName(@RequestParam String lastName) {
        return new ResponseEntity<List<User>>(userRepository.findByLastName(lastName), HttpStatus.OK);
    }

    //Find by type
    @GetMapping("/type")
    public ResponseEntity<List<User>> getUserByName(@RequestParam String type) {
        return new ResponseEntity<List<User>>(userRepository.findByType(type), HttpStatus.OK);
    }

    // build update user REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetails) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));
        updateUser.setFirstName(userDetails.getFirstName());
        updateUser.setLastName(userDetails.getLastName());
        updateUser.setEmailId(userDetails.getEmailId());
        updateUser.setType(userDetails.getType());
        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
