package com.crafter.springboottechiteasy.controllers;

import com.crafter.springboottechiteasy.Dtos.TelevisionDto;
import com.crafter.springboottechiteasy.Dtos.TelevisionInputDto;
import com.crafter.springboottechiteasy.models.Television;
import com.crafter.springboottechiteasy.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTVs() {
        return ResponseEntity.ok(televisionService.getAllTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getOneTV(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getOneTelevision(id));
    }

    @PostMapping("/add")
    public ResponseEntity<TelevisionDto> createNewTV(@RequestBody TelevisionDto tv) {
        return ResponseEntity.created(null).body(televisionService.createTelevision(tv));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<TelevisionDto> updateTV(@PathVariable Long id, @RequestBody TelevisionDto tv) {
        televisionService.updateTelevision(id, tv);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<TelevisionDto> deleteTV(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();

    }

}
