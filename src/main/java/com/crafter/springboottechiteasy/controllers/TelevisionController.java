package com.crafter.springboottechiteasy.controllers;

import com.crafter.springboottechiteasy.Dtos.IdInputDto;
import com.crafter.springboottechiteasy.Dtos.television.TelevisionInputDto;
import com.crafter.springboottechiteasy.Dtos.television.TelevisionOutputDto;
import com.crafter.springboottechiteasy.Dtos.television.TelevisionSalesDto;
import com.crafter.springboottechiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionOutputDto>> getAllTVs() {
        return ResponseEntity.ok(televisionService.getAllTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> getOneTV(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getOneTelevision(id));
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<TelevisionSalesDto> getSalesInfoOnOneTV(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getSalesInfoTelevision(id));
    }

    @PostMapping()
    public ResponseEntity<TelevisionOutputDto> createNewTV(@RequestBody TelevisionInputDto tv) {
        TelevisionOutputDto updatedTV = new TelevisionOutputDto();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedTV.getId())
                .toUri();
        return ResponseEntity.created(location).body(televisionService.createTelevision(tv));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> updateTV(@PathVariable Long id, @RequestBody TelevisionInputDto tv) {
        TelevisionOutputDto updatedTv = televisionService.updateTelevision(id, tv);
        return ResponseEntity.ok(updatedTv);
    }

    @PutMapping("/{id}/remote/{remoteId}")
    public void assignRemoteControllerToTelevision(@PathVariable("id") Long id, @PathVariable Long remoteId) {
        televisionService.assignRemoteToTelevision(id, remoteId);
    }

    @PutMapping("/{id}/cimodule")
    public void assignCiModuleToTelevision(@PathVariable("id") Long id, @RequestBody Long moduleId) {
        televisionService.assignCiModuleToTelevision(id, moduleId);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTV(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
}
