package com.crafter.springboottechiteasy.controllers;

import com.crafter.springboottechiteasy.exceptions.RecordNotFoundException;
import com.crafter.springboottechiteasy.exceptions.RequirementsNotMetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    @GetMapping
    public ResponseEntity<Object> getAllTVs() {
        return ResponseEntity.ok("television");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTV(@PathVariable int id) {
        if (id == 0) { // determine if id exists
            throw new IndexOutOfBoundsException();
        } else {
            return ResponseEntity.ok(id);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> createNewTV() {
        String television = "Panasonic";
        if (television.length() > 20) {
            throw new RequirementsNotMetException("The name is too long. There is a max of 20 characters");
        } else {
            return ResponseEntity.created(null).body("television");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateTV(@PathVariable int id, @RequestBody String televisionName) {
        if (id == 0) {
            throw new RecordNotFoundException();
        } else {

            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTV(@PathVariable int id) {
        if (id == 0) {
            throw new RecordNotFoundException();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
