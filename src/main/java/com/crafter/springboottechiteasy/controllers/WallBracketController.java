package com.crafter.springboottechiteasy.controllers;

import com.crafter.springboottechiteasy.Dtos.remote.RemoteInputDto;
import com.crafter.springboottechiteasy.Dtos.remote.RemoteOutputDto;
import com.crafter.springboottechiteasy.Dtos.wallBracket.WallbracketInputDto;
import com.crafter.springboottechiteasy.Dtos.wallBracket.WallbracketOutputDto;
import com.crafter.springboottechiteasy.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wbService) {
        this.wallBracketService = wbService;
    }

    @GetMapping
    public ResponseEntity<List<WallbracketOutputDto>> getAllRemotes() {
        return ResponseEntity.ok(wallBracketService.getAllWallBrackets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallbracketOutputDto> getOneWallBracket(@PathVariable Long id) {
        return ResponseEntity.ok(wallBracketService.getOneRemote(id));
    }

    @PostMapping()
    public ResponseEntity<WallbracketOutputDto> createNewWallBracket(@RequestBody WallbracketInputDto wb) {
        WallbracketOutputDto updatedRemote = new WallbracketOutputDto();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedRemote.getId())
                .toUri();
        return ResponseEntity.created(location).body(wallBracketService.createWallBracket(wb));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallbracketOutputDto> updateRemote(@PathVariable Long id, @RequestBody WallbracketInputDto wb) {
        WallbracketOutputDto updatedRemote = wallBracketService.updateWallBracket(id, wb);
        return ResponseEntity.ok(updatedRemote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemote(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }

}
