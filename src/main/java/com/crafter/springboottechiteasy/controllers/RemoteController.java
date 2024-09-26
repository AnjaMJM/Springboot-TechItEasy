package com.crafter.springboottechiteasy.controllers;

import com.crafter.springboottechiteasy.Dtos.remote.RemoteInputDto;
import com.crafter.springboottechiteasy.Dtos.remote.RemoteOutputDto;
import com.crafter.springboottechiteasy.services.RemoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remotes")
public class RemoteController {
    private final RemoteService remoteService;

    public RemoteController(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    @GetMapping
    public ResponseEntity<List<RemoteOutputDto>> getAllRemotes() {
        return ResponseEntity.ok(remoteService.getAllRemotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteOutputDto> getOneTV(@PathVariable Long id) {
        return ResponseEntity.ok(remoteService.getOneRemote(id));
    }

    @PostMapping()
    public ResponseEntity<RemoteOutputDto> createNewRemote(@RequestBody RemoteInputDto tv) {
        RemoteOutputDto updatedRemote = new RemoteOutputDto();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedRemote.getId())
                .toUri();
        return ResponseEntity.created(location).body(remoteService.createRemote(tv));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteOutputDto> updateRemote(@PathVariable Long id, @RequestBody RemoteInputDto tv) {
        RemoteOutputDto updatedRemote = remoteService.updateRemote(id, tv);
        return ResponseEntity.ok(updatedRemote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemote(@PathVariable Long id) {
        remoteService.deleteRemote(id);
        return ResponseEntity.noContent().build();
    }

}
