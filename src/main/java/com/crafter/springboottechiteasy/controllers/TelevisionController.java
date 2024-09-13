package com.crafter.springboottechiteasy.controllers;

import com.crafter.springboottechiteasy.exceptions.RecordNotFoundException;
import com.crafter.springboottechiteasy.exceptions.RequirementsNotMetException;
import com.crafter.springboottechiteasy.models.Television;
import com.crafter.springboottechiteasy.repositories.TelevisionRepository;
import com.crafter.springboottechiteasy.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTVs() {
        return ResponseEntity.ok(televisionService.getAllTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getOneTV(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getOneTelevision(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Television> createNewTV(@RequestBody Television t) {
        return ResponseEntity.created(null).body(televisionService.createTelevision(t));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Television> updateTV(@PathVariable Long id, @RequestBody Television tv) {
        televisionService.updateTelevision(id, tv);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Television> deleteTV(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();

    }

}
